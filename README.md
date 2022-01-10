
# - Afreecatv_assignment -

###<예시 영상>

https://www.youtube.com/watch?v=mKoRNabB3zk

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
***
