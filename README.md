# 🔲 Gerador de QR Code

Projeto fullstack para geração de QR Code a partir de uma URL.

## 🛠️ Tecnologias

- **Backend:** Java 17 + Spring Boot 3.2
- **Frontend:** HTML, CSS e JavaScript puro
- **Lib do google usada para gerar o QR Code:** [ZXing (Google)](https://github.com/zxing/zxing)

## 🚀 Como rodar

### Backend
mvn spring-boot:run

O servidor sobe em `http://localhost:8080`

### Frontend
Abra o arquivo `index.html` do frontend no navegador ou use o **Live Server** do VS Code.
digite o link que gere o qrcode
## 📡 Endpoint
```
GET /api/qrcode/generate?url=https://exemplo.com
```
Retorna a imagem PNG do QR Code gerado.
ARQUIVO DO FRONT JUNTO COM DO BACKEND PARA FACILIDADE DE ACESSO

## 👤 Autor

**vinigit22** — [github.com/vinigit22](https://github.com/vinigit22)
