## [<img src="https://d2gd6pc034wcta.cloudfront.net/tier/7.svg" width=20> 1120번](https://www.acmicpc.net/problem/1120)

# 문자열

| 시간 제한 | 메모리 제한 | 제출  | 정답 | 맞은 사람 | 정답 비율 |
| :-------- | :---------- | :---- | :--- | :-------- | :-------- |
| 2 초      | 128 MB      | 10394 | 5321 | 4656      | 52.362%   |

## 문제

길이가 N으로 같은 문자열 X와 Y가 있을 때, 두 문자열 X와 Y의 차이는 X[i] ≠ Y[i]인 i의 개수이다. 예를 들어, X=”jimin”, Y=”minji”이면, 둘의 차이는 4이다.

두 문자열 A와 B가 주어진다. 이때, A의 길이는 B의 길이보다 작거나 같다. 이제 A의 길이가 B의 길이와 같아질 때 까지 다음과 같은 연산을 할 수 있다.

1. A의 앞에 아무 알파벳이나 추가한다.
2. A의 뒤에 아무 알파벳이나 추가한다.

이때, A와 B의 길이가 같으면서, A와 B의 차이를 최소로 하는 프로그램을 작성하시오.

## 입력

첫째 줄에 A와 B가 주어진다. A와 B의 길이는 최대 50이고, A의 길이는 B의 길이보다 작거나 같고, 알파벳 소문자로만 이루어져 있다.

## 출력

A와 B의 길이가 같으면서, A와 B의 차이를 최소가 되도록 했을 때, 그 차이를 출력하시오.

## 예제 입력 1

```
adaabc aababbc
```

## 예제 출력 1

```
2
```

## 출처

- 문제를 번역한 사람: [baekjoon](https://www.acmicpc.net/user/baekjoon)
- 문제의 오타를 찾은 사람: [chsun0303](https://www.acmicpc.net/user/chsun0303)
- 빠진 조건을 찾은 사람: [jh05013](https://www.acmicpc.net/user/jh05013), [purpose](https://www.acmicpc.net/user/purpose)

## 알고리즘 분류

- [문자열](https://www.acmicpc.net/problem/tag/158)