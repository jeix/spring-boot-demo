# config

- ```
  $ curl \
  -H "Content-type: application/json" \
  -X POST localhost:8080/doit \
  -d '{"subject":"고구마","message":"고사리 고라니 고도리"}'
  ```
  - ```
    [{"foo":"고구마","bar":42,"qux":null},{"foo":"고구마","bar":42,"qux":["고사리","고라니"]}]
    ```

:wq