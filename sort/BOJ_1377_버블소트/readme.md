## [<img src="https://d2gd6pc034wcta.cloudfront.net/tier/13.svg" width=20> 1377번](https://www.acmicpc.net/problem/1377)

# 버블 소트

| 시간 제한 | 메모리 제한 | 제출 | 정답 | 맞은 사람 | 정답 비율 |
| :-------- | :---------- | :--- | :--- | :-------- | :-------- |
| 2 초      | 128 MB      | 7064 | 1925 | 1508      | 32.099%   |

## 문제

영식이는 다음과 같은 버블 소트 프로그램을 C++로 작성했다.

```c++
bool change = false;
for (int i=1; i<=n+1; i++) {
    change = false;
    for (int j=1; j<=n-i; j++) {
        if (a[j] > a[j+1]) {
            change = true;
            swap(a[j], a[j+1]);
        }
    }
    if (change == false) {
        cout << i << '\n';
        break;
    }c
}
```

위 소스에서 n은 배열의 

위 소스에서 n은 배열의 크기이고, a는 수가 들어있는 배열이다. 수는 배열의 1번방부터 채운다.

위와 같은 소스를 실행시켰을 때, 어떤 값이 출력되는지 구하는 프로그램을 작성하시오.

## 입력

첫째 줄에 N이 주어진다. N은 500,000보다 작거나 같은 자연수이다. 둘째 줄부터 N개의 줄에 A[1]부터 A[N]까지 하나씩 주어진다. A에 들어있는 수는 1,000,000보다 작거나 같은 자연수 또는 0이다.

## 출력

정답을 출력한다.

## 예제 입력 1 

```
5
10
1
5
2
3
```

## 예제 출력 1 

```
3
```

## 출처

- 문제를 번역한 사람: [baekjoon](https://www.acmicpc.net/user/baekjoon)
- 문제의 오타를 찾은 사람: [skynet](https://www.acmicpc.net/user/skynet)

## 알고리즘 분류

- [정렬](https://www.acmicpc.net/problem/tag/97)