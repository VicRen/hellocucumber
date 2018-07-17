Feature: 今天是星期五了么?
  人人都想知道今天是不是周五

  Scenario Outline: 今天是不是星期五
    Given 今天是 <day>
    When 我问今天是星期五了么
    Then 我应该被告知 <answer>

    Examples:
      | day | answer |
      | "星期五" | "是的" |
      | "星期日" | "不是" |
      | "周五" | "是的" |
      | "其他日子" | "不是" |