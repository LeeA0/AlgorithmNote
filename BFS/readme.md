# BFS - 너비 우선 탐색

* 너비 우선 탐색은 맹목적 탐색방법(blind search)<sup id="a1">[1](#bfs1)</sup>의 하나이다. 
* 시작 정점을 방문한 후 **시작 정점에 인접한 모든 정점들을 우선 방문하는 방법**이다.
* 더 이상 **방문하지 않은 정점이 없을 때가지 방문하지 않은 모든 정점들에 대해서도 너비 우선 검색을 적용**한다. 



# 장점

* 출발노드에서 목표노드까지의 최단 길이 경로를 보장한다.



# 단점

* 경로가 매우 길 경우
  * 탐색 가지가 급격히 증가함에 다라 보다 많은 memory를 필요로 한다.
* 유한 그래프(finity graph)의 경우
  * 해가 존재하지 않을 때 모든 그래프를 탐색한 후에 실패로 종료 한다.
* 무한 그래프(infinity graph)의 경우
  * 결코 해를 찾지 못하고, 끝내지도 못한다.





## 각주
<b id="bfs"><sup>1</sup></b>
[상태공간(state space)에 대한 정리](https://github.com/LeeA0/AlgorithmNote/wiki/%EC%83%81%ED%83%9C-%EA%B3%B5%EA%B0%84%EA%B3%BC-%ED%83%90%EC%83%89)[↩](#bfs1)



## 참고

[1] https://ko.wikipedia.org/wiki/%EB%84%88%EB%B9%84_%EC%9A%B0%EC%84%A0_%ED%83%90%EC%83%89

[2] https://ko.wikipedia.org/wiki/%EB%A7%B9%EB%AA%A9%EC%A0%81_%ED%83%90%EC%83%89
