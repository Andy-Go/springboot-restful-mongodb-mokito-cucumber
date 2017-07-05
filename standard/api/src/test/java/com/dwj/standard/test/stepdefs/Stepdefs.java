package com.dwj.standard.test.stepdefs;


import com.dwj.common.result.StringResult;
import com.dwj.standard.result.UserResult;
import com.dwj.standard.api.ApiApplication;
import com.dwj.standard.api.config.StandardProperties;
import com.google.common.collect.ImmutableMap;

import com.dwj.standard.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java8.En;


import static com.dwj.common.result.ResultCode.ARGUMENT_EXCEPTION;
import static com.dwj.common.result.ResultCode.SUCCESS;
import static org.assertj.core.api.Assertions.assertThat;

@ContextConfiguration(classes = ApiApplication.class)
@TestPropertySource("/application.properties")
public class Stepdefs implements En {

    @Autowired
    private StandardProperties standardProperties;

    protected RestTemplate restTemplate = new RestTemplate();
    private String name;
    private String pwd;
    private String uri;
    private String userId;
    private ResponseEntity<String> baseResponseResponseEntity;
    private User user;
    private UserResult result;

    private static final Map<String, Integer> resultMap = ImmutableMap.of(
            "成功", SUCCESS,
            "失败", ARGUMENT_EXCEPTION
    );

    @Before
    public void setUp() throws Exception {
        uri = "http://" + standardProperties.getUrl() + ":" + standardProperties.getPort() + standardProperties.getPath();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Given("^新增名为(\\S+),密码为(\\S+)的用户$")
    public void givenAddUser(String name, String pwd) throws Throwable {
        if (!"空".equals(name)) {
            this.name = name;
        }
        if (!"空".equals(pwd)) {
            this.pwd = pwd;
        }
    }

    @When("^调用新增接口$")
    public void when() throws Throwable {
        User user = User.newBuilder().pwd(pwd).name(name).build();
        ResponseEntity<UserResult> resultResponseEntity = restTemplate.postForEntity(uri + "/user", user, UserResult.class);
        result = resultResponseEntity.getBody();
    }

    @Then("^返回(\\S+)信息$")
    public void then(String message) throws Throwable {
        assertThat(result.getCode()).isEqualTo(resultMap.get(message));
    }

    @Given("^现有名为(\\S+),密码为(\\S+)的用户$")
    public void existUser(String name, String pwd) throws Throwable {
        User request = User.newBuilder().pwd(pwd).name(name).build();
        ResponseEntity<UserResult> addUserResponseResponseEntity = restTemplate.postForEntity(uri + "/user",
                request, UserResult.class);
        UserResult result = addUserResponseResponseEntity.getBody();
        userId = result.getPayload().getId();
    }


    @When("^调用查询接口,查询该用户$")
    public void 调用查询接口查询该用户() throws Throwable {
        ResponseEntity<UserResult> responseEntity = restTemplate.getForEntity(uri + "/user/" + userId, UserResult.class);
        UserResult result = responseEntity.getBody();
        user = result.getPayload();
    }

    @Then("^返回(\\S+)信息并且返回的用户名为(\\S+),密码为(\\S+)$")
    public void 返回的用户名为name密码为pwd(String message, String name, String pwd) throws Throwable {
        assertThat(user.getName()).isEqualTo(name);
        assertThat(user.getPwd()).isEqualTo(pwd);
    }
}
