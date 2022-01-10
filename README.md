
# - Afreecatv_assignment -
## 📱 과제 영상

https://www.youtube.com/watch?v=mKoRNabB3zk


## 🖼️ 예시 화면

![캡처](https://user-images.githubusercontent.com/42407740/148784751-8a6f5763-343d-4591-9fd1-adadd9eaee89.JPG)


## 📌 요구사항
 + 검색하고 싶은 Repository를 입력 받고, GitHub Search Repositories API의 응답으로 받아온 데이터를 사용하여 리스트를 표시합니다.

 + 리스트에 반드시 포함되어야 할 요소는 avatar_url, full_name, language 입니다.
    + 화면 구성은 예시 화면과 다르게 하셔도 무방합니다.

  + 리스트를 상하 스크롤이 가능하도록 표시합니다.

    + 페이징 기능 구현 : 한번에 10개의 데이터를 불러오고 리스트의 마지막에 도달하면 다음 페이지 데이터를 로딩해서 표시해줍니다. 로딩중 일 때 리스트 맨 밑에 로딩바를 활용하여 로딩중임을 알 수 있도록 해야 합니다.

  + 새로 검색을 하면 기존의 리스트는 제거하고, 검색결과에 따른 새로운 리스트를 표시합니다.


## 📄 API 명세서

### 1. Search Repositories API

- 해당 API 출처 : [https://docs.github.com/en/rest/reference/search#search-repositories](https://docs.github.com/en/rest/reference/search#search-repositories)
- API URL : https://api.github.com/search/repositories
- API Method : GET "`**/search/repositories**`"

### 2. Query Parameter

- q : String 타입으로, 해당 키워드를 가진 Repository들을 검색합니다.
- per_page : Integer  타입으로 한 페이지당 몇 개의 데이터를 받을 것인지 설정해줍니다. 본 과제에서는 10으로 설정해주시면 됩니다.
- page : Integer 타입으로, 전체 데이터를 per_page로 나누었을 때 원하는 page를 불러옵니다.

### 3. URL Example

- [https://api.github.com/search/repositories?q=tetris&per_page=10&page=1](https://api.github.com/search/repositories?q=tetris&per_page=10&page=1)

### 4. Response

- 전체 Response중에, 본 과제에서 사용할 filed는 아래와 같습니다.

| Field | Type | Description |
| --- | --- | --- |
| items | Array | Repository에 대한 다양한 데이터를 담고 있습니다. |
| full_name | String | Repository명을 나타냅니다. |
| owner | Object | 유저 프로필관련 정보를 담고 있습니다. |
| avatar_url | String | 유저 아바타 이미지 주소를 나타냅니다. |
| language | String | 해당 프로젝트에서 사용한 언어를 나타냅니다. |

```json
{
  "items": [
    {
      "full_name": "dtrupenn/Tetris",
      "owner": {
        "avatar_url": "https://secure.gravatar.com/avatar/e7956084e75f239de85d3a31bc172ace?d=https://a248.e.akamai.net/assets.github.com%2Fimages%2Fgravatars%2Fgravatar-user-420.png"
	...
      },
	"language": "kotlin"
	...
    }
  ]
}
```

## Architecture
![1](https://user-images.githubusercontent.com/42407740/148782238-2a2ad036-5d68-4c3d-8092-4803281f04a6.JPG)

> MVP패턴 간소화하여 사용

## 주요 기능 코드 및 설명

> 검색하고 싶은 Repository를 입력 받고, GitHub Search Repositories API의 응답으로 받아온 데이터를 사용하여 리스트를 표시합니다.
> 리스트에 반드시 포함되어야 할 요소는 avatar_url, full_name, language 입니다.
#### => API의 응답으로 받아온 데이터중에서 avatar_url, full_name, language만 recyclerview 데이터에 추가한다.
![2](https://user-images.githubusercontent.com/42407740/148782227-f4443818-410c-401a-bf36-d4e223c84001.JPG)


> 리스트를 상하 스크롤이 가능하도록 표시합니다.
#### => Adapter를 통해서 위에서 추가한 데이터들을 recyclerview에 연결하여 화면에 출력한다.
![3](https://user-images.githubusercontent.com/42407740/148782211-6b20ba0d-6cae-468c-bf3d-6919c9f1f0f4.JPG)


> 페이징 기능 구현 : 한번에 10개의 데이터를 불러오고 리스트의 마지막에 도달하면 다음 페이지 데이터를 로딩해서 표시해줍니다. 로딩중 일 때 리스트 맨 밑에 로딩바를 활용하여 로딩중임을 알 수 있도록 해야 합니다. 

```kotlin
SearchService(this).search(q, 10, page)
```
#### => 위에 코드를 통해서 10개의 데이터를 가져온다.

![4](https://user-images.githubusercontent.com/42407740/148782169-e409f92f-8220-4bab-9637-d107d04f1c7c.JPG)
#### => recyclerview에 addOnScrollListener를 달아서 스크롤이 젤 하단부에 닿았을때 다음 페이지의 데이터를 불러오고 로딩바를 없앤다. 이후 추가한 데이터(로딩바 포함)를 표시한다.

> 새로 검색을 하면 기존의 리스트는 제거하고, 검색결과에 따른 새로운 리스트를 표시합니다
#### => fragment로 만들어서 새로 검색할때마다 새 fragment로 교체한다.

![5](https://user-images.githubusercontent.com/42407740/148782094-aff2d2ff-a389-434d-8462-f649b7ecbf1e.JPG)

***
