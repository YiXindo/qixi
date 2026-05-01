<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>爱心祝福</title>
    <style>
        * { margin: 0; padding: 0; box-sizing: border-box; }
        body {
            font-family: 'Microsoft YaHei', sans-serif;
            background: linear-gradient(135deg, #1a1a2e, #16213e);
            color: white; min-height: 100vh; display: flex;
            flex-direction: column; align-items: center;
            justify-content: center; padding: 20px; text-align: center;
        }
        .container {
            max-width: 800px; width: 100%; background: rgba(255,255,255,0.05);
            border-radius: 20px; padding: 30px; box-shadow: 0 10px 30px rgba(0,0,0,0.3);
        }
        h1 { color: #ff6b6b; font-size: 2.5rem; margin-bottom: 20px; }
        .heart-area {
            width: 300px; height: 300px; position: relative; margin: 20px auto;
            background: rgba(255,255,255,0.02); border-radius: 10px;
            border: 2px dashed rgba(255,255,255,0.1);
        }
        .popup {
            position: absolute; background: #ff6b9d; color: white; padding: 8px 12px;
            border-radius: 8px; font-size: 14px; font-weight: bold; opacity: 0;
            transform: scale(0.5); transition: 0.3s; cursor: pointer; text-align: center;
            box-shadow: 0 4px 10px rgba(255,107,157,0.5);
        }
        button {
            background: #06d6a0; color: white; border: none; padding: 12px 25px;
            border-radius: 25px; font-size: 16px; margin: 10px; cursor: pointer;
            font-weight: bold;
        }
        #stopBtn { background: #ef476f; }
        .footer { margin-top: 30px; color: #a5b4fc; font-size: 14px; }
    </style>
</head>
<body>
    <div class="container">
        <h1>❤️ 爱心祝福 ❤️</h1>
        
        <div class="heart-area" id="heartContainer"></div>
        
        <div>
            <button onclick="startAnimation()">开始祝福</button>
            <button onclick="stopAnimation()" id="stopBtn">停止效果</button>
        </div>
        
        <div class="footer">
            <p>爱你的大帅哥送上，愿你天天好心情</p>
        </div>
    </div>

    <script>
        const blessings = [
            "美娇妻",
            "你是我的全世界",
            "美娇妻",
            "保持好心情",
            "好好爱自己",
            "你真的超级可爱",
            "美娇妻",
            "你笑起来最好看",
            "永远偏爱你",
            "开心每一天",
            "美娇妻",
            "你温柔又善良",
            "幸福永相伴",
            "健康平安",
            "我会一直陪着你",
            "美娇妻",
            "你是我的小宝贝",
            "累了就歇歇别逞强",
            "你值得所有美好",
            "美娇妻",
            "每天都更爱你一点",
            "你永远是我的首选",
            "照顾好自己哦",
            "美娇妻",
            "你在我心里最珍贵",
            "愿你永远被温柔以待",
            "我会一直宠着你",
            "美娇妻",
            "平安喜乐万事顺意",
            "你是我的满心欢喜"
        ];
        
        let popups = [];

        function getHeartPoints(count) {
            const points = [];
            for(let i = 0; i < count; i++) {
                const t = (i / count) * Math.PI * 2;
                const x = 16 * Math.pow(Math.sin(t), 3);
                const y = 13 * Math.cos(t) - 5 * Math.cos(2*t) - 2 * Math.cos(3*t) - Math.cos(4*t);
                points.push({ x: 150 - x * 8, y: 150 - y * 8 });
            }
            return points;
        }

        function startAnimation() {
            const container = document.getElementById('heartContainer');
            container.innerHTML = '';
            popups = [];
            const points = getHeartPoints(blessings.length);
            
            for(let i = 0; i < blessings.length; i++) {
                setTimeout(() => {
                    const popup = document.createElement('div');
                    popup.className = 'popup';
                    popup.textContent = blessings[i];
                    popup.style.left = points[i].x + 'px';
                    popup.style.top = points[i].y + 'px';
                    popup.style.background = ['#ff6b9d','#06d6a0','#ffd166','#118ab2'][i%4];
                    
                    popup.onclick = () => {
                        popup.style.opacity = 0;
                        popup.style.transform = 'scale(0.5)';
                        setTimeout(()=>popup.remove(),300);
                    };
                    
                    container.appendChild(popup);
                    popups.push(popup);
                    
                    setTimeout(()=>{
                        popup.style.opacity=1;
                        popup.style.transform='scale(1)';
                    },10);
                    
                    if(i === blessings.length-1){
                        setTimeout(()=>startDisappear(),1000);
                    }
                },i*200);
            }
        }

        function startDisappear(){
            for(let i=0;i<popups.length;i++){
                setTimeout(()=>{
                    if(popups[i]){
                        popups[i].style.opacity=0;
                        popups[i].style.transform='scale(0.5)';
                        setTimeout(()=>{
                            if(popups[i]?.parentNode) popups[i].parentNode.removeChild(popups[i]);
                        },300);
                    }
                },i*150);
            }
            setTimeout(()=>startAnimation(),popups.length*150+1000);
        }

        function stopAnimation(){
            popups.forEach(p=>{
                if(p?.parentNode){
                    p.style.opacity=0;
                    p.style.transform='scale(0.5)';
                    setTimeout(()=>p.remove(),300);
                }
            });
            popups=[];
        }

        document.addEventListener('DOMContentLoaded',()=>{
            setTimeout(startAnimation,1000);
        });
    </script>
</body>
</html>
