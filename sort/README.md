정렬 (선택, 버블, 삽입)

### 정렬 알고리즘

> 데이터를 특정한 기준에 따라서 순서대로 나열하는 것



### 1️⃣선택 정렬

> 처리되지 않은 데이터 중에서 가장 작은 데이터를 **선택** 하여 맨 앞의 데이터와 바꾸는 것

- 가장 원시적인 정렬 방법

![선택정렬 이미지 검색결과](https://img1.daumcdn.net/thumb/R800x0/?scode=mtistory2&fname=https%3A%2F%2Ft1.daumcdn.net%2Fcfile%2Ftistory%2F256B9C34545081D835)



- 선택 정렬은 가장 작은 데이터를 앞으로 보내는 과정을 **(N-1)번 반복**하면 정렬완료

```java
//구현 시 이중 반복문을 사용하여 구현할 수 있음
int[] a = {5, 3, 8, 1, 2, 7};
int min = 0; //가장 작은 원소의 인덱스를 저장할 변수

//선택정렬
for(int i=0; i<a.length; i++){
    min = i; //가장 작은 원소의 인덱스
    for(int j=i+1; j<a.length; j++){
        if(a[min] > a[j]){ //탐색하며 최소값 찾음
            min = j;
        }
    }
    
    //최소값 탐색을 마친 뒤 swap 코드
    int tmp = a[min];
    a[min] = a[i];
    a[i] = tmp;
}
```



#### 선택 정렬 :: 시간복잡도

---

- 선택 정렬은 N번만큼 가장 작은 수를 찾아서 맨 앞으로 보내야함
- 전체 연산 횟수 N + (N-1) + (N-2) + ... + 2  
- 이중 반복문 사용

![image-20210207220500825](C:\Users\multicampus\AppData\Roaming\Typora\typora-user-images\image-20210207220500825.png)


- 데이터의 개수가 10,000개 이상이면 정렬 속도가 급격히 느려짐

| 데이터의 개수(N) | 선택정렬 |
| :--------------: | :------: |
|      N =100      | 0.0123초 |
|    N = 1,000     | 0.354초  |
|    N = 10,000    | 15.475초 |



### 2️⃣버블 정렬

> 바로 옆에 있는 값과 비교해서 더 작은 값을 앞으로 보내는 것을 반복하는 방법

![버블정렬 이미지 검색결과](https://img1.daumcdn.net/thumb/R800x0/?scode=mtistory2&fname=https%3A%2F%2Ft1.daumcdn.net%2Fcfile%2Ftistory%2F275F9A4A545095BD01)

- 구현은 가장 쉽지만 가장 비효율적인 알고리즘

- 비교를 반복하며 가장 큰 값이 뒤로 이동하여 fix 된다

```java
//구현 시 이중 반복문을 사용하여 구현할 수 있음
int[] a = {5, 3, 8, 1, 2, 7};
for(int i=0; i<a.length; i++){
    for(int j=0; j<a.length-i-1; j++){ 
        if(a[j] > a[j+1]){ //왼쪽의 값이 오른쪽보다 크다면
            //swap
            int tmp = a[j];
            a[j] = a[j+1];
            a[j+1] = tmp;
        }
    }
}
```



#### 버블 정렬 :: 시간복잡도

---

- 선택정렬과 시간 복잡도는 같다

![image-20210207220541387](C:\Users\multicampus\AppData\Roaming\Typora\typora-user-images\image-20210207220541387.png)


- **BUT) ** 실제로 수행했을 때 선택 정렬보다 느리게 작동

  > why? 자리를 바꾸는 연산 작업을 선택정렬보다 월등히 많이 수행함 
  >
  > 따라서 컴퓨터 내부적인 연산이 가장 비효율적으로 일어나고 
  >
  > 실제 수행시간이 정렬 알고리즘 중 가장 느린 알고리즘



### 3️⃣삽입 정렬

> 각 숫자를 **적절한 위치에 삽입**하는 방법

- 삽입 정렬은 현재 위치에서 앞의 원소들이 정렬되어 있다는 것을 가정

![삽입정렬 이미지 검색결과](https://img1.daumcdn.net/thumb/R800x0/?scode=mtistory2&fname=https%3A%2F%2Ft1.daumcdn.net%2Fcfile%2Ftistory%2F2569FD3854508BE811)



#### 삽입 정렬 :: 시간복잡도

---

- 선택정렬과 버블정렬과 마찬가지로 시간 복잡도는 같다

![image-20210207220528307](C:\Users\multicampus\AppData\Roaming\Typora\typora-user-images\image-20210207220528307.png)

- 선택정렬과 삽입정렬은 무조건 위치를 바꿈, 그리고 이미 정렬이 이루어져 있어도 반복을 수행하게 됨

  **BUT)** 삽입정렬은 필요할때만 바꿈

  > 따라서 시간 복잡도는 동일할지라도 실제 수행속도는 (선택, 버블과 비교하면) 삽입정렬이 더 빠름
  >
  > 세가지의 알고리즘 중 연산 횟수가 가장 작아서 셋 중에는 가장 뛰어난 알고리즘
  >
  > ex) 2 3 4 5 6 7 8 9 10 1 과 같이 거의 정렬되어 있는 경우 굉장히 시간이 빠름
  

```java
int[] a = {5, 3, 8, 1, 2, 7};
for(int i=0; i<a.length; i++){
    int j = i;
    while(a[j] > a[j+1]){ //왼쪽의 값이 더 크다면
        //swap을 통해 뒤로 보냄
        int tmp = a[j];
        a[j] = a[j+1];
        a[j+1] = tmp;
        j--;
    }
}
```





##### 참고)

> 알고리즘 문제 풀 때 정렬을 할 때 직접 구현을 해서 사용하는 방법?
>
> 실제 코테에서는 기본 정렬 라이브러리 sort() 와 같은 것을 사용할 수 있음
>
> 따라서 정렬이 필요한 경우 이를 사용하는 것이 유리함
>
> 대부분의 언어에서 지원하는 정렬 라이브러리는 최적화가 잘 되어 있다





### 객체 비교

---

```java
public class Student implements Comparable<Student> {
    String name;
    int score;
    
    public Student(String name, int score){
        this.name = name;
        this.score = score;
    }
}
```

- 다음과 같은 객체가 있다고 할 때 점수를 기준으로 정렬하는 방법

> comparable, comparator 공통
>
> return 타입은 int
>
> - a < b 음수
> - a==b 0
> - a > b 양수



#### Comparable 

> java.lang.Comparable을 구현 Comparable에는 compareTo() 메소드가 정의, 일반적인 정렬 필요 할 때

```java
public class Student implements Comparable<Student> {
	//필드 생략
    @Override
    public int compareTo(Student o) {
        return this.score - o.score; //오름차순
        return o.score - this.score; //내림차순
        return this.name.compareTo(o.name); //문자열 비교 오름차순 (아스키코드값으로 비교)
    }
}
```





#### Comparator 

> Objects.compare(T a, T b, Comparator<T>c) 메소드는 두 객체를 Comparator로 비교하여 int값을 리턴, 특정한 정렬 필요할 때

- java.util.Comparator<T> 는 compare(T a, T b) 메소드가 내부적으로 정의되어 있음

 ```java
  static class Student implements Comparator<Student>{
      String name;
      int score;
      
      public Student(String name, int score){
          this.name = name;
          this.score = score;
      }
      
      @Override
      public int compare(Student a, Student b){
          return Integer.compare(a.score, b.score); //오름차순
      }
  }
 ```

  

> 익명 클래스 사용

```java
Comparator<Student> scomparator = new Comparator<Student>() { // 익명 클래스 사용
    @Override
    public int compare(Student a, Student b) {
        return a.getScore() - b.getScore(); //오름차순
    }
};

Collections.sort(list, scomparator); //sort 할 때 comparator 이름을 같이 넘겨줌
```



> 람다 함수

```java
Collections.sort(list, (a, b) -> a.getScore() - b.getScore()); 
```
