# Java Algorithm

## Overview

- 코딩 테스트 대비
- Visual Studio Code (vscode) 사용
- <code>F5</code> 키를 눌러 build & run
- <code>command + shift + b</code> 를 눌러 compile-java, create-jar 를 선택하여 사용 가능

## Main content

- [취업과 이직을 위한 프로그래머스 코딩 테스트 문제 풀이 전략: 자바 편](https://blog.rgbplace.com/453)
- JAVA 관련 강의자료 정리
- Do it! 자료구조와 함께 배우는 알고리즘 입문 : 자바편
- LeetCode, HackerRank, 프로그래머스

## VS Code Config (for Mac)

- Users > [사용자 명] > Library > Application Support > Code > User 에 있는 <code>setting.json</code> 파일에 아래와 같은 설정이 되어 있는지 확인한다.

```json
{
  "java.jdt.ls.java.home": "/Library/Java/JavaVirtualMachines/temurin-17.jdk/Contents/Home",
  "java.configuration.runtimes": [
    {
      "name": "JavaSE-17",
      "path": "/Library/Java/JavaVirtualMachines/temurin-17.jdk/Contents/Home",
      "default": true
    }
  ]
}
```

reference : https://github.com/redhat-developer/vscode-java/issues/2852