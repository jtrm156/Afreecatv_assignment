
# - Afreecatv_assignment -
## ๐ฑ ๊ณผ์  ์์

https://www.youtube.com/watch?v=mKoRNabB3zk


## ๐ผ๏ธย ์์ ํ๋ฉด

![์บก์ฒ](https://user-images.githubusercontent.com/42407740/148784751-8a6f5763-343d-4591-9fd1-adadd9eaee89.JPG)


## ๐ย ์๊ตฌ์ฌํญ
 + ๊ฒ์ํ๊ณ  ์ถ์ Repository๋ฅผ ์๋ ฅ ๋ฐ๊ณ , GitHub Search Repositories API์ ์๋ต์ผ๋ก ๋ฐ์์จ ๋ฐ์ดํฐ๋ฅผ ์ฌ์ฉํ์ฌ ๋ฆฌ์คํธ๋ฅผ ํ์ํฉ๋๋ค.

 + ๋ฆฌ์คํธ์ ๋ฐ๋์ ํฌํจ๋์ด์ผ ํ  ์์๋ avatar_url, full_name, language ์๋๋ค.
    + ํ๋ฉด ๊ตฌ์ฑ์ ์์ ํ๋ฉด๊ณผ ๋ค๋ฅด๊ฒ ํ์๋ ๋ฌด๋ฐฉํฉ๋๋ค.

  + ๋ฆฌ์คํธ๋ฅผ ์ํ ์คํฌ๋กค์ด ๊ฐ๋ฅํ๋๋ก ํ์ํฉ๋๋ค.

    + ํ์ด์ง ๊ธฐ๋ฅ ๊ตฌํ : ํ๋ฒ์ 10๊ฐ์ ๋ฐ์ดํฐ๋ฅผ ๋ถ๋ฌ์ค๊ณ  ๋ฆฌ์คํธ์ ๋ง์ง๋ง์ ๋๋ฌํ๋ฉด ๋ค์ ํ์ด์ง ๋ฐ์ดํฐ๋ฅผ ๋ก๋ฉํด์ ํ์ํด์ค๋๋ค. ๋ก๋ฉ์ค ์ผ ๋ ๋ฆฌ์คํธ ๋งจ ๋ฐ์ ๋ก๋ฉ๋ฐ๋ฅผ ํ์ฉํ์ฌ ๋ก๋ฉ์ค์์ ์ ์ ์๋๋ก ํด์ผ ํฉ๋๋ค.

  + ์๋ก ๊ฒ์์ ํ๋ฉด ๊ธฐ์กด์ ๋ฆฌ์คํธ๋ ์ ๊ฑฐํ๊ณ , ๊ฒ์๊ฒฐ๊ณผ์ ๋ฐ๋ฅธ ์๋ก์ด ๋ฆฌ์คํธ๋ฅผ ํ์ํฉ๋๋ค.


## ๐ย API ๋ช์ธ์

### 1. Search Repositories API

- ํด๋น API ์ถ์ฒ : [https://docs.github.com/en/rest/reference/search#search-repositories](https://docs.github.com/en/rest/reference/search#search-repositories)
- API URL : https://api.github.com/search/repositories
- API Method : GET "`**/search/repositories**`"

### 2. Query Parameter

- q : String ํ์์ผ๋ก, ํด๋น ํค์๋๋ฅผ ๊ฐ์ง Repository๋ค์ ๊ฒ์ํฉ๋๋ค.
- per_page : Integer  ํ์์ผ๋ก ํ ํ์ด์ง๋น ๋ช ๊ฐ์ ๋ฐ์ดํฐ๋ฅผ ๋ฐ์ ๊ฒ์ธ์ง ์ค์ ํด์ค๋๋ค. ๋ณธ ๊ณผ์ ์์๋ 10์ผ๋ก ์ค์ ํด์ฃผ์๋ฉด ๋ฉ๋๋ค.
- page : Integer ํ์์ผ๋ก, ์ ์ฒด ๋ฐ์ดํฐ๋ฅผ per_page๋ก ๋๋์์ ๋ ์ํ๋ page๋ฅผ ๋ถ๋ฌ์ต๋๋ค.

### 3. URL Example

- [https://api.github.com/search/repositories?q=tetris&per_page=10&page=1](https://api.github.com/search/repositories?q=tetris&per_page=10&page=1)

### 4. Response

- ์ ์ฒด Response์ค์, ๋ณธ ๊ณผ์ ์์ ์ฌ์ฉํ  filed๋ ์๋์ ๊ฐ์ต๋๋ค.

| Field | Type | Description |
| --- | --- | --- |
| items | Array | Repository์ ๋ํ ๋ค์ํ ๋ฐ์ดํฐ๋ฅผ ๋ด๊ณ  ์์ต๋๋ค. |
| full_name | String | Repository๋ช์ ๋ํ๋๋๋ค. |
| owner | Object | ์ ์  ํ๋กํ๊ด๋ จ ์ ๋ณด๋ฅผ ๋ด๊ณ  ์์ต๋๋ค. |
| avatar_url | String | ์ ์  ์๋ฐํ ์ด๋ฏธ์ง ์ฃผ์๋ฅผ ๋ํ๋๋๋ค. |
| language | String | ํด๋น ํ๋ก์ ํธ์์ ์ฌ์ฉํ ์ธ์ด๋ฅผ ๋ํ๋๋๋ค. |

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

> MVPํจํด ๊ฐ์ํํ์ฌ ์ฌ์ฉ

## ์ฃผ์ ๊ธฐ๋ฅ ์ฝ๋ ๋ฐ ์ค๋ช

> ๊ฒ์ํ๊ณ  ์ถ์ Repository๋ฅผ ์๋ ฅ ๋ฐ๊ณ , GitHub Search Repositories API์ ์๋ต์ผ๋ก ๋ฐ์์จ ๋ฐ์ดํฐ๋ฅผ ์ฌ์ฉํ์ฌ ๋ฆฌ์คํธ๋ฅผ ํ์ํฉ๋๋ค.
> ๋ฆฌ์คํธ์ ๋ฐ๋์ ํฌํจ๋์ด์ผ ํ  ์์๋ avatar_url, full_name, language ์๋๋ค.
#### => API์ ์๋ต์ผ๋ก ๋ฐ์์จ ๋ฐ์ดํฐ์ค์์ avatar_url, full_name, language๋ง recyclerview ๋ฐ์ดํฐ์ ์ถ๊ฐํ๋ค.
![2](https://user-images.githubusercontent.com/42407740/148782227-f4443818-410c-401a-bf36-d4e223c84001.JPG)


> ๋ฆฌ์คํธ๋ฅผ ์ํ ์คํฌ๋กค์ด ๊ฐ๋ฅํ๋๋ก ํ์ํฉ๋๋ค.
#### => Adapter๋ฅผ ํตํด์ ์์์ ์ถ๊ฐํ ๋ฐ์ดํฐ๋ค์ recyclerview์ ์ฐ๊ฒฐํ์ฌ ํ๋ฉด์ ์ถ๋ ฅํ๋ค.
![3](https://user-images.githubusercontent.com/42407740/148782211-6b20ba0d-6cae-468c-bf3d-6919c9f1f0f4.JPG)


> ํ์ด์ง ๊ธฐ๋ฅ ๊ตฌํ : ํ๋ฒ์ 10๊ฐ์ ๋ฐ์ดํฐ๋ฅผ ๋ถ๋ฌ์ค๊ณ  ๋ฆฌ์คํธ์ ๋ง์ง๋ง์ ๋๋ฌํ๋ฉด ๋ค์ ํ์ด์ง ๋ฐ์ดํฐ๋ฅผ ๋ก๋ฉํด์ ํ์ํด์ค๋๋ค. ๋ก๋ฉ์ค ์ผ ๋ ๋ฆฌ์คํธ ๋งจ ๋ฐ์ ๋ก๋ฉ๋ฐ๋ฅผ ํ์ฉํ์ฌ ๋ก๋ฉ์ค์์ ์ ์ ์๋๋ก ํด์ผ ํฉ๋๋ค. 

```kotlin
SearchService(this).search(q, 10, page)
```
#### => ์์ ์ฝ๋๋ฅผ ํตํด์ 10๊ฐ์ ๋ฐ์ดํฐ๋ฅผ ๊ฐ์ ธ์จ๋ค.

![4](https://user-images.githubusercontent.com/42407740/148782169-e409f92f-8220-4bab-9637-d107d04f1c7c.JPG)
#### => recyclerview์ addOnScrollListener๋ฅผ ๋ฌ์์ ์คํฌ๋กค์ด ์ ค ํ๋จ๋ถ์ ๋ฟ์์๋ ๋ค์ ํ์ด์ง์ ๋ฐ์ดํฐ๋ฅผ ๋ถ๋ฌ์ค๊ณ  ๋ก๋ฉ๋ฐ๋ฅผ ์์ค๋ค. ์ดํ ์ถ๊ฐํ ๋ฐ์ดํฐ(๋ก๋ฉ๋ฐ ํฌํจ)๋ฅผ ํ์ํ๋ค.

> ์๋ก ๊ฒ์์ ํ๋ฉด ๊ธฐ์กด์ ๋ฆฌ์คํธ๋ ์ ๊ฑฐํ๊ณ , ๊ฒ์๊ฒฐ๊ณผ์ ๋ฐ๋ฅธ ์๋ก์ด ๋ฆฌ์คํธ๋ฅผ ํ์ํฉ๋๋ค
#### => fragment๋ก ๋ง๋ค์ด์ ์๋ก ๊ฒ์ํ ๋๋ง๋ค ์ fragment๋ก ๊ต์ฒดํ๋ค.

![5](https://user-images.githubusercontent.com/42407740/148782094-aff2d2ff-a389-434d-8462-f649b7ecbf1e.JPG)

***
