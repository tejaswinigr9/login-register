<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>WebPage</title>
<link rel="stylesheet" href="styles.css">
</head>
<body>

<header>
<nav>
<ul>
  <li><a href="index.jsp">Home</a></li>
    <li><a href="login.jsp">Login</a></li>
    <li><a href="register.jsp">Register</a></li>
 </ul>
</nav>
</header>

<main>
<p>Welcome to our Techmiya Solutions website. Please feel free to explore and login or register to access more features.</p>

<div class="slider-container">
<img class="slider active" src="WhatsApp Image 2024-12-26 at 11.12.52 AM.jpg" alt="Image 1">
<img class="slider" src="image.jpg" alt="Image 2">
<img class="slider" src="image3.jpg" alt="Image 3">
<button class="prev" onclick="changeSlide(-1)">&#10094;</button>
<button class="next" onclick="changeSlide(1)">&#10095;</button>
</div>

</main>

<footer>
<p>&copy; 2024 Techmiya Solutions. All Rights Reserved.</p>
</footer>

<script>
let currentSlide=0;
const slides =document.querySelectorAll('.slider');
function changeSlide(n){
	slides[currentSlide].classList.remove('active');
	currentSlide = (currentSlide + n + slides.length) % slides.length;
	slides[currentSlide].classList.add('active');
}
setInterval(()=> changeSlide(1),5000);
</script>

</body>
</html>