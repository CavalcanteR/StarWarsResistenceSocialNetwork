Avaliação 

API em REST Java
- Java
- Spring boot
- Hibernate
- Maven

Status 
- Em andamento


Uso da API
- Software utilizado : Postman

    - Adicionar Rebelde
        - POST
        - localhost:9000/rebeldes
        - Headers: Content-Type: application/json
        - Body: 
            {
            "nome":"Ricardo Cavalcante",
            "idade":40,
            "latitude":28.88,
            "longitude":99.88,
            "base":"Teste",
            "genero":"m"
            }
    
    - Listar Rebeldes
        - GET
        - localhost:9000/rebeldes
    
    - Editar Localização do rebelde
        - PATCH
        - localhost:9000/rebeldes/[id]
        - Headers: Content-Type: application/json
        - Body: 
            {
            "latitude":15.33,
            "longitude":15.55,
            "base":"death star"
            }
        

