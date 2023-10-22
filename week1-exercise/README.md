# Getting Started

### Requirements
[Lecture-1](/Lecture-1.pdf)

### Guides

## Following APIs are implemented:

- Get user's movies: 
    - `GET` `users/{id}/movies`
        - Request:
            - Query param: `id`: user id
        - Reponse:
            - Body:
            ```json
            {
                result_code: 200,
                result_message: "success",
                movies: [
                        {
                            id: 1,
                            title: "Gone with the wind",
                        },
                        {
                            id: 2,
                            title: "The last samurai",
                        },
                    ....
                ]
            }

            ```
- Add movie to user's liked list: 
    - `POST` `users/{id}/like`
        - Request:
            - Query param: `id`: user id
            - Body:
            ```json
            {
                movie_id: 1,
            }
            ```
        - Reponse:
            - Body:
            ```json
            {
                result_code: 200,
                result_message: "success",
            }

            ```
- Remove movie from user's liked list: 
    - `DEL` `users/{id}/unlike`
        - Request: 
            - Query param: `id`: user id
            - Body:
            ```json
            {
                movie_id: 1,
            }
            ```
        - Reponse:
            - Body:
            ```json
            {
                result_code: 200,
                result_message: "success",
            }

            ```

## Database: H2

## Unit test: not implemented yet