window.onload = function () {
    document.querySelector('#file').onchange = function (){
        if(this.files.length){
            let file = this.files[0];
            let reader = new FileReader();
            //新建 FileReader 对象
            reader.onload = function(){
                // 当 FileReader 读取文件时候，读取的结果会放在 FileReader.result 属性中
                document.querySelector('#img').src = this.result;
                document.querySelector('#text').innerHTML = this.result;
            };
            // 设置以什么方式读取文件，这里以base64方式
            reader.readAsDataURL(file);
        }
    }
}
