const http = require('http');
const obj = {
    code: "200",
    message: "ok",
    result: [{
        name: "Tom",
        age: "20",
        url: "https://raw.githubusercontent.com/Nirvana-cn/Photograph-deposit/master/douyu/game1.png"
    }, {
        name: "Jack",
        age: "19",
        url: "https://raw.githubusercontent.com/Nirvana-cn/Photograph-deposit/master/douyu/game5.png"
    }]
};

http.createServer(function (req, res) {
    res.writeHead(200, {'Content-Type': 'text/plain'});
    res.write(JSON.stringify(obj));
    res.end();

}).listen(3000);

console.log("Server is running at http://localhost:3000");