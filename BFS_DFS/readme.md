# BFS, DFS 란?

- 두 방법 모두 **모든 정점을 한번만 방문한다**는 같은 목표를 가지고 있지만, 탐색하는 방식에서 차이가 있다.
- 탐색 여부 확인을 할 수 있는 배열이 필요하다.
- 많은 연산량이 요구되기 때문에, 꼼꼼한 설계와 예외적인 상황에 대한 고려가 필수적이다.

## DFS ( **D**epth **F**irst **S**earch)

- **깊이 우선** 탐색

- 한 정점을 골라서 더 깊이 들어갈 수 있는 곳까지 탐색해서 들어가다가, 끝에 다다르면 바로 이전의 깊이의 정점으로 돌아와서 다른 방향의 정점을 다시 방문하는 방식

- **정점에 방문함과 동시에 방문체크**를 해서 해당 정점에 다시 방문하지 않도록 한다.

  ### 장점

  - 이동하는데 가중치가 붙거나, 이동과정에서 여러가지 제약이 있을 경우, 탐색시간이 더 걸리지만, 가중치에 대한 변수를 지속해서 관리할 수 있다.
  - 재귀호출, 스택을 이용한 DFS로 백트래킹을 구현할 수 있다.
- 현재 경로상의 노드들만 기억하면 되므로 저장공간의 소요가 비교적 적다
  
  - 목표노드가 깊은 단계에 있을 경우에 해를 빨리 구할 수 있다.
- 어떤 한 임의의 노드에서 길을 따라 가보면 자기 자신으로 돌아올 수 있는 경로가 있는지 확인이 가능하므로, **그래프에 사이클이 있는지 여부**도 확인도 가능하다
  
  ### 단점

  - 해가 없는 경로에 너무 깊이 빠지게 될 가능성이 있다. 따라서 실제 경우에는 미리 지정한 임의의 깊이(depth bound)까지만 탐색하고 목표노드를 발견하지 못하면 다음 경로를 따라 탐색하는 방법을 취해야 한다.
  - 당장 얻어진 경로가 최단 경로가 아닐 수 있다. 
    다시 말하면, 목표까지의 경로가 여러개인 문제에 대해서 DFS는 목표에 도달하면 탐색을 종료하므로, 이때 찾은 경로는 최적의 경로가 아닐 수 있다.

dfs 기본코드

```java
import java.util.Iterator;
import java.util.LinkedList;

class dfs {

	/** main 함수 */
	public static void main(String args[]) {
		Graph g = new Graph(4);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		g.DFS(2); /* 주어진 노드를 시작 노드로 DFS 탐색 */
		System.out.println();
		g.DFS(); /* 비연결형 그래프의 경우 */
	}
	/* 인접 리스트 이용 */
	static class Graph {
		private int V;
		private LinkedList<Integer> adj[];

		Graph(int v) {
			V = v;
			adj = new LinkedList[v];
			// 인접 리스트 초기화
			for (int i = 0; i < v; ++i)
				adj[i] = new LinkedList();
		}

		void addEdge(int v, int w) {
			adj[v].add(w);
		}

		/* DFS에 의해 사용되는 함수 */
		void DFSUtil(int v, boolean visited[]) {
			// 현재 노드를 방문한 것으로 표시하고 값을 출력
			visited[v] = true;
			System.out.print(v + " ");

			// 방문한 노드와 인접한 모든 노드를 가져온다.
			Iterator<Integer> it = adj[v].listIterator();
			while (it.hasNext()) {
				int n = it.next();
				// 방문하지 않은 노드면 해당 노드를 시작 노드로 다시 DFSUtil 호출
				if (!visited[n])
					DFSUtil(n, visited);
			}
		}

		/* DFS 탐색 (시작 노드가 주어진 경우) */
		void DFS(int v) {
			// 방문 여부 판단용 배열
			boolean visited[] = new boolean[V];

			// v를 시작 노드로 DFSUtil 재귀 호출
			DFSUtil(v, visited);
		}

		/** DFS 탐색 (시작 노드가 주어지지 않은 경우) */
		void DFS() {
			// 노드의 방문 여부 판단 (초깃값: false)
			boolean visited[] = new boolean[V];

			// 비연결형 그래프의 경우, 모든 정점을 하나씩 방문
			for (int i = 0; i < V; ++i) {
				if (visited[i] == false)
					DFSUtil(i, visited);
			}
		}

	}
}
```

코드 출처 : https://gmlwjd9405.github.io/2018/08/14/algorithm-dfs.html



DFS 관련 참고하면 좋을 사이트 : https://blog.encrypted.gg/942



## BFS ( Breadth First Search )

- **너비 우선** 탐색.

- 탐색 시작점의 인접한 정점들을 먼저 모두 차례로 방문한 후에, 방문했던 정점을 시작점으로 하여 다시 인접한 정점을 차례로 방문하는 방식

- **큐에 같은 정점이 두번 들어가지 않도록 하기 위해서** **큐에 넣음과 동시에 방문 체크**를 해야한다.

  ### 장점

  - 출발 정점에서부터의 거리를 단계별로 순회하여,  DFS와 다르게 목표 정점에 도달했을 때 최단 길이 경로를 보장합니다.

    (모든 간선의 가중치가 동일할 경우)
  
  - BFS 알고리즘이 활약할 수 있는 경우
  **1. 최소 비용 문제** - 미로 탐색을 할 때 **최단 거리만을 가져야 할 때**
  
    **2. 간선의 가중치가 1이다.**

    **3. 정점과 간선의 개수가 적다. (시간 제약, 메모리 제한 내에 만족한다.)**
  
  ### 단점
  
  - 최악의 경우 모든 정점에 대한 정보를 위한 공간이 필요하게 된다.
  - 어짜피 모든 경우의 수를 
  - 목표하는 정점이 깊은 단계에 있을 경우 시간이 많이 소요된다.
  

bfs 기본코드

```java
import java.util.Iterator;
import java.util.LinkedList;

public class bfs {
	public static void main(String[] args) {
		Graph g = new Graph(4);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		g.search(1); // 1을 시작 노드로 하여 탐색
	}

	static class Graph {
		private int V;
		private LinkedList<Integer> adj[];

		Graph(int v) {
			V = v;
			adj = new LinkedList[v];
			for (int i = 0; i < v; ++i)
				adj[i] = new LinkedList();
		}

		void addEdge(int v, int w) {
			adj[v].add(w);
		}

		/* BFS */
		void search(int s) {
			boolean visited[] = new boolean[V];
			LinkedList<Integer> queue = new LinkedList<Integer>();

			visited[s] = true;
			queue.add(s);

			while (queue.size() != 0) {
				// 방문한 노드를 큐에서 추출(dequeue)하고 값을 출력
				s = queue.poll();
				System.out.print(s + " ");

				// 방문한 노드와 인접한 모든 노드를 가져온다.
				Iterator<Integer> i = adj[s].listIterator();
				while (i.hasNext()) {
					int n = i.next();
					// 방문하지 않은 노드면 방문한 것으로 표시하고 큐에 삽입(enqueue)
					if (!visited[n]) {
						visited[n] = true;
						queue.add(n);
					}
				}
			}
		}
	}

}
```

코드 출처 : https://enfanthoon.tistory.com/141


BFS 관련 추가로 보면 좋을 사이트 : https://blog.encrypted.gg/941

