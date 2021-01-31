# 재귀란 무엇인가?

* 재귀란 함수가 자기 자신을 호출하여 순환하여 수행되는 것

* 재귀(자기호출)은 어떤 문제를 해결하는 과정에서 자신과 똑같지만 크기가 다른 문제를 발견하고 이들의 관계를 파악함으로써 문제 해결에 간명하게 접근하는 방식

  - 기본 재귀 코드

    ```java
    private static void recursive(){
        System.out.println("Recursive call");
        recursive(); <--자기 자신을 다시 호출한다!
    }
    ```

* 큰 단위의 작업을 같은 형태의 더 작은 작업으로 만들어 문제를 해결



# 재귀에서의 수학적 귀납법

#### 수학적 귀납법

> 귀납적 정의에서는, “무한 집합의 모든 멤버가 어떠한 성질 **P**를 가짐”을 보이기 위하여, “작은 멤버들을 사용하여 큰 멤버들이 참(**P**의 성질을 가짐)임”을 증명하는 방법을 사용한다.

1. **Base Step** : P(base) 를 증명 , 여기서 base = 0, 1, 2 ... 등으로 임의의 상수
2. Hypothesis Step : P(K-1) 이 참이라 가정하고 P(K) 를 증명 , 여기서 k = 임의의 정수
3. **Inductive Step** :모든 자연수 n 에 대해 P(n) 이 참임을 증명



#### 재귀호출에 대한 귀납법

> 재귀적 정의에서는, “작은 멤버들에 함수/술어/집합을 적용(정의)하여 모든 멤버들을 정의”하는 방법을 
>
> 사용한다.
>
> 재귀란 객체를 정의하는데 있어서 해당 객체 자신을 사용하는 것을 의미한다.
>
> 귀납적 증명은 *P*(*n*+1)이 참임을 증명하기 위하여 재귀적으로 *P*(*n*)을 사용하는 것으로 해석할 수 있다.



1. Hypothesis : 재귀 호출이 P 를 만족한다고 가정
2. Inductive : 현재 호출이 P 를 만족함을 증명
3. 재귀 호출이 유한번 만에 끝날때 P 를 만족



#### 연관성

* **자기 자신을 사용하여 문제를 해결한다는 것이다.**



# Basis step and Inductive step

* ```java
  private static int factorial(int n){
  	//basis step
  	if(n<=1)
  		return 1;
  	//inductive step
  	else	
  		return (n * factorial(n-1));
  }
  ```

* Basis step (기초 단계)

  * 종료조건, 기저조건이라 불린다.
  * 재귀함수로 인한 StackOverflow는 올바른 기저조건이 설정되어있지 않기 때문에 발생하는 경우가 매우 크다.

* Inductive step (귀납적 단계)

  * 

# 재귀호출의 예

#### 팩토리얼

* 팩토리얼의 기본 수식

$$
n! = n * (n-1) * (n-2) * (n-3) * ... * 2 * 1
$$

​																											       ▼
$$
n! = n * (n-1)!
$$

* 따라서 팩토리얼은 다음과 같이 표현할 수 있다.

![img](https://latex.codecogs.com/gif.latex?%5Cinline%20%5Cdpi%7B100%7D%20%5Cbg_white%20%5CLARGE%20f%28n%29%20%3D%5Cleft%5C%7B%5Cbegin%7Bmatrix%7D%20n%20*%20f%28n-1%29%20%26%20n%5Cgeq%201%5C%5C%201%20%26%20n%3D0%20%5Cend%7Bmatrix%7D%5Cright.)

+ 이를 코드로 표현하면

  ```java
  int factorial(int n)
  {
      //basis
      if(n==0)
          return 1;
  	
      //inductive
      return n * factorial(n-1);
  }
  ```

+ 

### 피보나치

* 이전의 두 수 합을 다음 항으로 하는 수열을 피보나치라 한다.

* 피보나치의  n번째 위치의 값을 반환하는 함수는 다음과 같이 표현할 수 있다.

  

  ![img](https://latex.codecogs.com/gif.latex?%5Cinline%20%5Cdpi%7B100%7D%20%5Cbg_white%20%5CLARGE%20f%28n%29%20%3D%5Cleft%5C%7B%5Cbegin%7Bmatrix%7D%200%20%26%20n%3D1%5C%5C%201%20%26%20n%3D2%5C%5C%20fib%28n-1%29&plus;fib%28n-2%29%20%26%20otherwise%20%5Cend%7Bmatrix%7D%5Cright.)

  

* 이를 코드로 표현하면

  ```java
  int fibonacci(int n){
  	//basis
      if(n==1) 	  return 0; //n=1
      else if(n==2) return 1; //n=2
      else		  return fibonacci(n-1) + fibonacci(n-2); //otherwise
  }
  ```

* 피보나치를 재귀적으로 풀면 다음과 같이 매우 많은 중복이 발생한다.

  ![Image for post](https://miro.medium.com/max/925/1*svQ784qk1hvBE3iz7VGGgQ.jpeg)

  ​				출처 :[medium.com](https://medium.com/launch-school/recursive-fibonnaci-method-explained-d82215c5498e)

  

* 이를 해결하기 위해 **메모이제이션**을 사용한다.

* ```java
  int memo[100];
  
  int fibonacci(int n){
  	if(n==1) 	  return 0;
  	else if(n==2) return 1;
  	//memo 배열에 기억해둔 값을 return 한다. 이로써 중복 계산을 막을 수 있다.
  	if(memo[n] != 0) return memo[n]; 
  	else 
  		return memo[n] = fibonacci(n-1) + fibonacci(n-2);
  }
  ```

  

### 하노이 탑

- 하나의 막대에 쌓여 있는 원반을 다른 하나의 원반에 그대로 옮기는 방법에 관한 문제이다.

  - 조건
    - 원반은 한번에 하나씩만 옮길 수 있다.
    - 옮기는 과정에서 작은 원반의 위에 큰 원반이 올려져서는 안된다.

  ![img](https://upload.wikimedia.org/wikipedia/commons/6/60/Tower_of_Hanoi_4.gif)

- 문제를 재귀적으로 해결하는 방법

  1. 작은 원반 n-1개를 A에서 B기둥으로 이동시킨다.

  2. 큰 원반 1개를 A에서 C로 이동시킨다.

  3. 작은 원반 n-1개를 B에서 C로 이동시킨다.

     

- 이를 코드로 표현하면

  ```java
  //n개의 원반을 by를 거쳐 from에서 to로 이동시킨다.
  void hanoiTower(int n, char from, char by, char to){
     
      //basis
      if(n==1) {
          print("원반 1을 "+from+"에서" + to +"로 이동");
      }
      
      //inductive
      else{
          //1단계 : 작은원반 n-1개를 A기둥에서 B기둥으로 이동
          hanoiTower(n-1, from, to, by);//출발지, 경유지, 목적지
          
          //2단계 : 큰 원반 1개를 A에서 C로 이동
          print("원반 "+ n +"을 "+ from +"에서" + to +"로 이동"); 
          
          //3단계 : 작은 원반 n-1개를 B에서 C로 이동시킨다. 
          hanoiTower(n-1, by, from, to); //출발지, 경유지, 목적지
      }
  }
  ```

  





# 분할 정복

#### 분할 정복이란?

* 분할정복에서는 각 재귀 호출 레벨 위에서 다음 세 가지 단계를 거치면서 재귀적으로 문제를 푼다.

  

  > **분할** : 현재의 문제와 동일하되 입력의 크기가 더 작은 다수의 부분 문제로 분할한다.
  >
  > **정복** : 부분 문제를 재귀적으로 풀어서 정복한다. 부분 문제의 크기가 충분히 작으면 직접적인 방법으로 푼다.
  >
  > **결합** : 부분 문제의 해를 결합해 원래 문제의 해가 되도록 만든다.

  

* 부분 문제가 재귀적으로 풀 수 있을 만큼 충분히 클 때 **재귀 대상**이라고 하며 부분 문제가 충분히 작아져 더 이상 재귀 호출을 할 수 없을 때 재귀가 **"바닥을 쳤다"**고 하고, 이를 **base case**까지 내려왔다고 한다. 때로는 입력의 크기가 더 작은 완전히 동일한 부분 문제 외에 원래의 문제와 다른 부분 문제를 풀어야 할 때도 있다. 이런 부분 문제는 결합 단계의 일부로 간주한다.



#### 분할 정복의 대표적인 예

#### Merge-Sort

* **점화식** 

  ![img](https://latex.codecogs.com/gif.latex?%5Cinline%20%5Cdpi%7B100%7D%20%5Cbg_white%20%5CLARGE%20T%28n%29%20%3D%5Cleft%5C%7B%5Cbegin%7Bmatrix%7D%20%5CTheta%281%29%20%26%20n%3D1%5C%5C%202T%28%5Cfrac%7Bn%7D%7B2%7D%29&plus;%5CTheta%28n%29%20%26%20n%3E1%20%5Cend%7Bmatrix%7D%5Cright.)

* **Merge-Sort의 해**

  ![img](https://latex.codecogs.com/gif.latex?%5Cinline%20%5Cdpi%7B100%7D%20%5Cbg_white%20%5CLARGE%20T%28n%29%20%3D%20%5CTheta%20%28n%20lg%20n%29)



* **code**

  ```java
  mergeSort(A,p,r)
  if(p < r){
  	q = floor((p+r)/2)
  	mergeSort(A, p, q);   //왼쪽 분할 대상
  	mergeSort(A, q+1, r); //오른쪽 분할 대상
  	merge(A, p, q, r); 	  //병합
  }
  ```

  

