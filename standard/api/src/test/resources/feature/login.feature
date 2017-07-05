Feature: 标准的增删改查例子
  """
  新增用户
  """
  Scenario: 新增用户成功
    Given 新增名为name,密码为pwd的用户
    When 调用新增接口
    Then 返回成功信息

  Scenario: 新增用户失败
    Given 新增名为空,密码为pwd的用户
    When 调用新增接口
    Then 返回失败信息

  Scenario: 查询已经存在用户
    Given 现有名为name,密码为pwd的用户
    When 调用查询接口,查询该用户
    Then 返回成功信息并且返回的用户名为name,密码为pwd