Feature: 今天是黑色星期五么？
  人们不喜欢黑色星期五
  Scenario: 使用 And 可以拼接条件
    Given 今天是星期五
    And 今天是13日
    When 我提问今天是黑色星期五么？
    Then 我被告知 "是的"