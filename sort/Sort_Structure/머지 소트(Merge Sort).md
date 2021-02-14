## 머지 소트(Merge Sort)

---

### 들어가기전에

![image](https://user-images.githubusercontent.com/70404643/107871192-cdd6c200-6ee2-11eb-80b2-c99485b41646.png)

![image](https://user-images.githubusercontent.com/70404643/107871194-d3cca300-6ee2-11eb-932a-39089f3fe443.png)

![image](https://user-images.githubusercontent.com/70404643/107871205-e34bec00-6ee2-11eb-9fdc-f35424a5935e.png)

![image](https://user-images.githubusercontent.com/70404643/107871197-db8c4780-6ee2-11eb-88d4-bc8cfcb81e13.png)

![merge sort 이미지 검색결과](https://upload.wikimedia.org/wikipedia/commons/thumb/e/e6/Merge_sort_algorithm_diagram.svg/300px-Merge_sort_algorithm_diagram.svg.png)

병합 정렬이라고도 부르며, 분할 정복 방법을 통해 구현

***분할 정복이란?***

> 큰 문제를 작은 문제 단위로 쪼개면서 해결해나가는 방식



빠른 정렬로 분류되며, 퀵소트와 함께 많이 언급되는 정렬 방식이다.



퀵소트와는 반대로 `안정 정렬`에 속함

**시간복잡도**

![image](https://user-images.githubusercontent.com/70404643/107871210-ea72fa00-6ee2-11eb-8cf6-6afa85e822e5.png)

|   평균   |   최선   |   최악   |
| :------: | :------: | :------: |
| O(nlogn) | O(nlogn) | O(nlogn) |

요소를 쪼갠 후, 다시 합병시키면서 정렬해나가는 방식으로, 쪼개는 방식은 퀵정렬과 유사

## 대표소스

```java
package final_algo.data_structure;

public class MergeSort {
	private static void mergeSort(int[] arr) {
		// 배열의 크기만큼 임시 저장소를 생성
		int tmp[] = new int[arr.length];
		mergeSort(arr, tmp, 0, arr.length - 1);
	}

	/**
	 * 재귀 함수
	 * @param arr 정렬할 배열
	 * @param tmp 임시 저장소
	 * @param start 시작 index
	 * @param end 끝 index
	 */
	private static void mergeSort(int[] arr, int[] tmp, int start, int end) {
		if (start < end) {
			//중간점
			int mid = (start + end) / 2;
			//배열의 앞부분으로 start ~ mid
			mergeSort(arr, tmp, start, mid);
			//배열의 뒷부분으로 mid ~ end
			mergeSort(arr,tmp,mid + 1, end);
			//왼쪽 정렬과 오른쪽 정렬을 합치는 merge
			merge(arr, tmp, start, mid, end);
		}
	}
	/**
	 * 정렬된 배열들을 합쳐주는 함수
	 * @param arr 배열
	 * @param tmp 배열 임시공간
	 * @param start 시작점
	 * @param mid 중간점 
	 * @param end 끝점
	 */
	private static void merge (int [] arr, int [] tmp, int start, int mid, int end) {
		for(int i = start; i <= end; i++) {
			tmp[i] = arr[i];
		}
		//왼쪽 정렬 배열의 첫 점
		int part1 = start;
		//오른쪽 정렬 배열의 첫 점
		int part2 = mid + 1;
		//결과 배열의 index, 두개의 배열 중 작은 값을 넣는 index 자리값을 나타내는 값, 이후 하나씩 늘려주며 다음에 저장할 공간을 기억하게 함.
		int index = start;
		//전체 범위를 탐색
		while(part1 <= mid && part2 <= end) {
			//만약 앞의 앞의 비교값이 더 작으면
			if(tmp[part1] <= tmp[part2]) {
				//arr에 index 위치에 part1을 넣는다.
				arr[index] = tmp[part1];
				//그리고 넣은 part1의 index를 1올려준다.
				part1++;
			}else {
				arr[index] =tmp [part2];
				part2++;
			}
			//arr[index]값을 1올려준다.
			index++;
		}
		//위 경우는 왼쪽 배열이나 오른쪽 배열 두 배열중 하나가 빌때 까지 적용된다.
		//그랬을 경우 만약 왼쪽 배열의 남아있는 값들을 arr[index + 1]해서 붙여준다.
		//오른쪽 배열이 남을 경우는 이미 arr[index]뒤쪽으로 자리하고 있기 때문에 따로 정의해줄 필요가 없다.
		for (int i = 0; i <= mid-part1; i++) {
			arr[index + i] = tmp[part1 + i];
		}
	}

	private static void printArray(int[] arr) {
		for (int data : arr) {
			System.out.print(data + ", ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		int [] arr = {3,9,4,7,5,0,1,6,8,2};
		printArray(arr);
		mergeSort(arr);
		printArray(arr);
	}
}

```



### 상세소스

- mergeSort

```java
public void mergeSort(int[] array, int left, int right) {
    
    if(left < right) {
        int mid = (left + right) / 2;
        
        mergeSort(array, left, mid);
        mergeSort(array, mid+1, right);
        merge(array, left, mid, right);
    }
    
}
```

정렬 로직에 있어서 merge() 메소드가 핵심



*퀵소트와의 차이점*

> 퀵정렬 : 우선 피벗을 통해 정렬(partition) → 영역을 쪼갬(quickSort)
>
> 합병정렬 : 영역을 쪼갤 수 있을 만큼 쪼갬(mergeSort) →  정렬(merge)



- merge()

```java
public static void merge(int[] array, int left, int mid, int right) {
    int[] L = Arrays.copyOfRange(array, left, mid + 1);
    int[] R = Arrays.copyOfRange(array, mid + 1, right + 1);
    
    int i = 0, j = 0, k = left;
    int ll = L.length, rl = R.length;
    
    while(i < ll && j < rl) {
        if(L[i] <= R[j]) {
            array[k] = L[i++];
        }
        else {
            array[k] = R[j++];
        }
        k++;
    }
    
    // remain
    while(i < ll) {
        array[k++] = L[i++];
    }
    while(j < rl) {
        array[k++] = R[j++];
    }
}
```

이미 **합병의 대상이 되는 두 영역이 각 영역에 대해서 정렬이 되어있기 때문**에 단순히 두 배열을 **순차적으로 비교하면서 정렬할 수가 있다.**





**★★★합병정렬은 순차적**인 비교로 정렬을 진행하므로, **LinkedList의 정렬이 필요할 때 사용하면 효율적**이다.★★★



*LinkedList를 퀵정렬을 사용해 정렬하면?*

> 성능이 좋지 않음
>
> 퀵정렬은, 순차 접근이 아닌 **임의 접근이기 때문**



**LinkedList는 삽입, 삭제 연산에서 유용**하지만 **접근 연산에서는 비효율적**임

따라서 임의로 접근하는 퀵소트를 활용하면 오버헤드 발생이 증가하게 됨

> 배열은 인덱스를 이용해서 접근이 가능하지만, LinkedList는 Head부터 탐색해야 함
>
> 배열[O(1)] vs LinkedList[O(n)] 





```java
private void solve() {
    int[] array = { 230, 10, 60, 550, 40, 220, 20 };
 
    mergeSort(array, 0, array.length - 1);
 
    for (int v : array) {
        System.out.println(v);
    }
}
 
public static void mergeSort(int[] array, int left, int right) {
    if (left < right) {
        int mid = (left + right) / 2;
 
        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);
        merge(array, left, mid, right);
    }
}
 
public static void merge(int[] array, int left, int mid, int right) {
    int[] L = Arrays.copyOfRange(array, left, mid + 1);
    int[] R = Arrays.copyOfRange(array, mid + 1, right + 1);
 
    int i = 0, j = 0, k = left;
    int ll = L.length, rl = R.length;
 
    while (i < ll && j < rl) {
        if (L[i] <= R[j]) {
            array[k] = L[i++];
        } else {
            array[k] = R[j++];
        }
        k++;
    }
 
    while (i < ll) {
        array[k++] = L[i++];
    }
 
    while (j < rl) {
        array[k++] = R[j++];
    }
}
```

