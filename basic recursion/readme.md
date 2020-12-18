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

  * 

* Inductive step (귀납적 단계)

  * 

# 재귀호출의 예

* 팩토리얼
  - 2단계
    + 3단계
      + 4단계

* 피보나치
  - 2단계
    + 3단계
      + 4단계

* 하노이
  - 2단계
    + 3단계
      + 4단계
