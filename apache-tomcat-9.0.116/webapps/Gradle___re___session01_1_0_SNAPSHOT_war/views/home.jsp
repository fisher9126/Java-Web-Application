<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Trang cá nhân - Home</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: 'Segoe UI', sans-serif;
        }

        body {
            background: linear-gradient(135deg, #4facfe, #00f2fe);
            color: #333;
        }

        .container {
            width: 90%;
            max-width: 1100px;
            margin: auto;
            padding: 20px;
        }

        header {
            text-align: center;
            padding: 50px 0;
            color: white;
        }

        header h1 {
            font-size: 40px;
        }

        header p {
            font-size: 18px;
            margin-top: 10px;
        }

        .card {
            background: white;
            border-radius: 15px;
            padding: 30px;
            margin: 20px 0;
            box-shadow: 0 10px 25px rgba(0,0,0,0.1);
        }

        .about {
            display: flex;
            align-items: center;
            gap: 20px;
        }

        .about img {
            width: 150px;
            height: 150px;
            border-radius: 50%;
            object-fit: cover;
        }

        .skills span {
            display: inline-block;
            background: #4facfe;
            color: white;
            padding: 8px 12px;
            border-radius: 20px;
            margin: 5px;
        }

        footer {
            text-align: center;
            color: white;
            margin-top: 30px;
            padding: 20px;
        }

        .btn {
            display: inline-block;
            padding: 10px 20px;
            background: #4facfe;
            color: white;
            border-radius: 25px;
            text-decoration: none;
            margin-top: 10px;
        }

        .btn:hover {
            background: #007bff;
        }
    </style>
</head>
<body>

<div class="container">

    <!-- HEADER -->
    <header>
        <h1>Xin chào, tôi là <%= "RE" %> 👋</h1>
        <p>Lập trình viên | Java Developer | Web Developer</p>
    </header>

    <!-- ABOUT -->
    <div class="card about">
        <img src="https://i.pravatar.cc/150" alt="avatar">
        <div>
            <h2>Giới thiệu</h2>
            <p>
                Tôi là một lập trình viên đam mê phát triển web bằng Java, JSP và Spring.
                Tôi thích xây dựng các ứng dụng đẹp, nhanh và thân thiện với người dùng.
            </p>
            <a href="#" class="btn">Liên hệ</a>
        </div>
    </div>

    <!-- SKILLS -->
    <div class="card">
        <h2>Kỹ năng</h2>
        <div class="skills">
            <span>Java</span>
            <span>JSP/Servlet</span>
            <span>HTML/CSS</span>
            <span>JavaScript</span>
            <span>Spring Boot</span>
            <span>MySQL</span>
        </div>
    </div>

    <!-- PROJECTS -->
    <div class="card">
        <h2>Dự án</h2>
        <ul>
            <li>📌 Website bán hàng (JSP + Servlet)</li>
            <li>📌 Hệ thống quản lý sinh viên</li>
            <li>📌 Blog cá nhân</li>
        </ul>
    </div>

    <!-- JSP dynamic demo -->
    <div class="card">
        <h2>Thông tin hệ thống</h2>
        <p>Thời gian hiện tại: <%= new java.util.Date() %></p>
    </div>

    <!-- FOOTER -->
    <footer>
        <p>© 2026 - Trang cá nhân của RE</p>
    </footer>

</div>

</body>
</html>