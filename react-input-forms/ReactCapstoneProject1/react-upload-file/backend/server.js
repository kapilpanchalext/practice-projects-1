const express = require('express');
const app = express();
const cors = require('cors');

app.use(cors());

app.get("/getRequest", (req, res) => {
    console.log(`Get Request from Server`)
    return res.status(200).json({ result: true, msg: 'Hello from Server' });
});

app.post("/upload", (req, res) => {
    // use modules such as express-fileupload, Multer, Busboy
    
    setTimeout(() => {
        console.log('file uploaded');
        console.log(res);
        return res.status(200).json({ result: true, msg: 'file uploaded' });
    }, 3000);
});

app.delete("/upload", (req, res) => {
    console.log(`File deleted`)
    return res.status(200).json({ result: true, msg: 'file deleted' });
});

app.listen(9001, () => {
    console.log(`Server running on port 9001`)
});