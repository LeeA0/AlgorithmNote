## [<img src="https://d2gd6pc034wcta.cloudfront.net/tier/8.svg" width=20> 1706번](https://www.acmicpc.net/problem/1706)

# 크로스워드

| 시간 제한 | 메모리 제한 | 제출 | 정답 | 맞은 사람 | 정답 비율 |
| :-------- | :---------- | :--- | :--- | :-------- | :-------- |
| 2 초      | 128 MB      | 434  | 188  | 166       | 45.604%   |

## 문제

동혁이는 크로스워드 퍼즐을 좋아한다. R×C 크기의 크로스워드 퍼즐을 생각해 보자. 이 퍼즐은 R×C 크기의 표로 이루어지는데, 퍼즐을 다 풀면 금지된 칸을 제외하고는 각 칸에 알파벳이 하나씩 적혀 있게 된다. 아래는 R = 5, C = 5 인 경우 다 푼 퍼즐의 한 예이다. 검은 칸은 금지된 칸이다.

![img](https://www.acmicpc.net/JudgeOnline/upload/201005/cross.PNG)

세로 또는 가로로 연속되어 있고, 더 이상 확장될 수 없는 낱말이 퍼즐 내에 존재하는 단어가 된다. 위의 퍼즐과 같은 경우, 가로 낱말은 good, an, messy, it, late의 5개가 있고, 세로 낱말은 game, one, sit, byte의 4개가 있다. 이 중 사전식 순으로 가장 앞서 있는 낱말은 an이다.

다 푼 퍼즐이 주어졌을 때, 퍼즐 내에 존재하는 모든 낱말 중 사전식 순으로 가장 앞서 있는 낱말을 구하는 프로그램을 작성하시오.

## 입력

첫째 줄에는 퍼즐의 R과 C가 빈 칸을 사이에 두고 주어진다. (2 ≤ R, C ≤ 20) 이어서 R개의 줄에 걸쳐 다 푼 퍼즐이 주어진다. 각 줄은 C개의 알파벳 소문자 또는 금지된 칸을 나타내는 #로 이루어진다. 낱말이 하나 이상 있는 입력만 주어진다.

## 출력

첫째 줄에 사전식 순으로 가장 앞서 있는 낱말을 출력한다.

## 예제 입력 1

```
4 5
adaca
da##b
abb#b
abbac
```

## 예제 출력 1

```
abb
```

## 출처

- 문제를 번역한 사람: [author5](https://www.acmicpc.net/user/author5)

## 알고리즘 분류

- [그래프 이론](https://www.acmicpc.net/problem/tag/7)
- [그래프 탐색](https://www.acmicpc.net/problem/tag/11)
- [문자열](https://www.acmicpc.net/problem/tag/158)
- [정렬](https://www.acmicpc.net/problem/tag/97)
- [파싱](https://www.acmicpc.net/problem/tag/96)