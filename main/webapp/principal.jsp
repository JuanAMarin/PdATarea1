<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="publicadores.ControladorPublishAcceso" %>
<%@ page import="publicadores.ControladorPublishAccesoService" %>
<%@ page import="publicadores.ControladorPublishAccesoServiceLocator" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="icon" href="imagenes/icono.jpg">
<link rel="stylesheet" href="css/pages.css">
<title>Men�</title>
</head>
<body>
	<% ControladorPublishAccesoService cpsA = new ControladorPublishAccesoServiceLocator();
	  ControladorPublishAcceso portA = cpsA.getControladorPublishAccesoPort();
	  if(!portA.pIsNull()){%>
		<jsp:include page="headerP.jsp" />
	<%}else{%>
		<jsp:include page="headerS.jsp" />
	<%}%>
	
	<div class="leaderboard" style="align-items: center">
	
		<rect width="640" height="400" x="0" y="0" opacity="1" fill="#ffffff" data-fill-palette-color="background" id="background"></rect><g id="tight-bounds" transform="matrix(1,0,0,1,122.24000000000001,76.4)"><svg viewBox="0 0 395.52 247.2" height="247.2" width="395.52"><g><svg></svg></g><g><svg viewBox="0 0 395.52 247.2" height="247.2" width="395.52"><g><path d="M129.824 0h135.872l-4.763 31.33-131.109 0zM263.561 247.2h-133.737v-31.33l133.737 0z" fill="#ff0000" data-fill-palette-color="tertiary"></path></g><g transform="matrix(1,0,0,1,0,40.87969968120993)"><svg viewBox="0 0 395.52 165.44060063758013" height="165.44060063758013" width="395.52"><g><svg viewBox="0 0 395.52 165.44060063758013" height="165.44060063758013" width="395.52"><g><svg viewBox="0 0 395.52 165.44060063758013" height="165.44060063758013" width="395.52"><g transform="matrix(1,0,0,1,0,99.99535756952108)"><svg viewBox="0 0 395.52 65.44524306805906" height="65.44524306805906" width="395.52"><g><svg viewBox="0 0 395.52 65.44524306805906" height="65.44524306805906" width="395.52"><g><svg viewBox="0 0 395.52 65.44524306805906" height="65.44524306805906" width="395.52"><g transform="matrix(1,0,0,1,0,0)"><svg width="395.52" viewBox="1.850000023841858 -34.75 277.66998291015625 45.95000076293945" height="65.44524306805906" data-palette-color="#ffffff"><path d="M1.85-34.75L20.95-34.75 20-28.5 10.7-28.5 10.7-20.7 18.9-20.7 18.9-14.55 10.7-14.55 10.7-6.3 20.65-6.3 20.65 0 1.85 0 1.85-34.75ZM37.85-27.55Q40.65-27.55 42.27-25.5 43.9-23.45 43.9-20L43.9-20 43.9 0 35.4 0 35.4-19.15Q35.4-21.1 34.4-21.1L34.4-21.1Q33.85-21.1 33.25-20.43 32.65-19.75 31.85-18.4L31.85-18.4 31.85 0 23.35 0 23.35-26.65 30.75-26.65 31.35-23.7Q32.7-25.65 34.22-26.6 35.75-27.55 37.85-27.55L37.85-27.55ZM60.05-6.4L62.8-1.25Q61.45-0.2 59.7 0.35 57.95 0.9 56.15 0.9L56.15 0.9Q52.05 0.9 50-1.4 47.95-3.7 47.95-7.65L47.95-7.65 47.95-20.75 45.45-20.75 45.45-26.65 47.95-26.65 47.95-32.35 56.45-33.35 56.45-26.65 61.34-26.65 60.5-20.75 56.45-20.75 56.45-7.75Q56.45-5.8 58.09-5.8L58.09-5.8Q59-5.8 60.05-6.4L60.05-6.4ZM77.59-27.4Q78.79-27.4 79.74-27L79.74-27 78.34-18.85Q77.44-19.15 76.44-19.15L76.44-19.15Q74.64-19.15 73.79-17.75 72.94-16.35 72.39-13.65L72.39-13.65 72.39 0 63.89 0 63.89-26.65 71.29-26.65 71.89-22.35Q73.74-27.4 77.59-27.4L77.59-27.4ZM102.19-13.75Q102.19-12.55 101.99-10.85L101.99-10.85 88.64-10.85Q88.84-7.6 89.84-6.4 90.84-5.2 92.69-5.2L92.69-5.2Q94.04-5.2 95.24-5.73 96.44-6.25 97.94-7.35L97.94-7.35 101.34-2.85Q99.59-1.1 97.27-0.1 94.94 0.9 92.04 0.9L92.04 0.9Q86.19 0.9 83.19-2.85 80.19-6.6 80.19-13.2L80.19-13.2Q80.19-19.75 83.04-23.65 85.89-27.55 91.29-27.55L91.29-27.55Q96.34-27.55 99.27-24.05 102.19-20.55 102.19-13.75L102.19-13.75ZM93.89-15.8L93.89-16.15Q93.89-19.3 93.36-20.7 92.84-22.1 91.39-22.1L91.39-22.1Q90.04-22.1 89.39-20.78 88.74-19.45 88.59-15.8L88.59-15.8 93.89-15.8ZM119.24-27.55Q122.04-27.55 123.66-25.5 125.29-23.45 125.29-20L125.29-20 125.29 0 116.79 0 116.79-19.15Q116.79-21.1 115.79-21.1L115.79-21.1Q115.24-21.1 114.64-20.43 114.04-19.75 113.24-18.4L113.24-18.4 113.24 0 104.74 0 104.74-26.65 112.14-26.65 112.74-23.7Q114.09-25.65 115.61-26.6 117.14-27.55 119.24-27.55L119.24-27.55ZM147.94-7.5Q147.94-6.25 148.19-5.7 148.44-5.15 149.19-4.8L149.19-4.8 147.44 0.75Q145.19 0.55 143.74-0.25 142.28-1.05 141.49-2.8L141.49-2.8Q139.09 0.9 134.84 0.9L134.84 0.9Q131.49 0.9 129.51-1.38 127.53-3.65 127.53-7.45L127.53-7.45Q127.53-11.8 130.31-14.15 133.09-16.5 138.34-16.5L138.34-16.5 139.63-16.5 139.63-17.55Q139.63-19.85 138.99-20.7 138.34-21.55 136.59-21.55L136.59-21.55Q134.49-21.55 130.99-20.25L130.99-20.25 129.09-25.5Q131.19-26.45 133.63-27 136.09-27.55 138.28-27.55L138.28-27.55Q143.19-27.55 145.56-25.23 147.94-22.9 147.94-18.05L147.94-18.05 147.94-7.5ZM137.53-5.05Q138.19-5.05 138.74-5.58 139.28-6.1 139.63-7.05L139.63-7.05 139.63-11.9 139.03-11.9Q137.34-11.9 136.56-11.03 135.78-10.15 135.78-8.25L135.78-8.25Q135.78-6.7 136.26-5.88 136.74-5.05 137.53-5.05L137.53-5.05ZM177.23-27.55Q179.88-27.55 181.46-25.5 183.03-23.45 183.03-20L183.03-20 183.03 0 174.68 0 174.68-19.2Q174.68-20.2 174.43-20.68 174.18-21.15 173.68-21.15L173.68-21.15Q172.58-21.15 171.43-18.75L171.43-18.75 171.43 0 163.23 0 163.23-19.2Q163.23-21.15 162.23-21.15L162.23-21.15Q161.08-21.15 159.93-18.75L159.93-18.75 159.93 0 151.63 0 151.63-26.65 159.03-26.65 159.53-23.6Q160.88-25.6 162.38-26.58 163.88-27.55 165.78-27.55L165.78-27.55Q167.58-27.55 168.88-26.5 170.18-25.45 170.88-23.45L170.88-23.45Q173.43-27.55 177.23-27.55L177.23-27.55ZM197.13-27.55Q202.48-27.55 205.5-24 208.53-20.45 208.53-13.3L208.53-13.3Q208.53-6.45 205.48-2.78 202.43 0.9 197.08 0.9L197.08 0.9Q191.73 0.9 188.71-2.68 185.68-6.25 185.68-13.35L185.68-13.35Q185.68-20.25 188.71-23.9 191.73-27.55 197.13-27.55L197.13-27.55ZM197.13-21.35Q195.63-21.35 195-19.58 194.38-17.8 194.38-13.35L194.38-13.35Q194.38-8.75 195-7 195.63-5.25 197.08-5.25L197.08-5.25Q198.58-5.25 199.21-7.03 199.83-8.8 199.83-13.3L199.83-13.3Q199.83-17.85 199.21-19.6 198.58-21.35 197.13-21.35L197.13-21.35ZM219.93-27.55Q222.48-27.55 224.73-26.68 226.98-25.8 228.58-24.25L228.58-24.25 225.58-19.7Q222.88-21.55 220.78-21.55L220.78-21.55Q219.73-21.55 219.18-21.05 218.63-20.55 218.63-19.7L218.63-19.7Q218.63-19 218.95-18.53 219.28-18.05 220.18-17.53 221.08-17 223.03-16.2L223.03-16.2Q226.33-14.8 227.88-12.93 229.43-11.05 229.43-7.95L229.43-7.95Q229.43-3.9 226.53-1.5 223.63 0.9 218.88 0.9L218.88 0.9Q216.03 0.9 213.48-0.15 210.93-1.2 209.13-3.1L209.13-3.1 213.03-7.45Q216.13-5 218.43-5L218.43-5Q219.53-5 220.18-5.58 220.83-6.15 220.83-7.15L220.83-7.15Q220.83-8.4 220.03-9.18 219.23-9.95 216.63-11L216.63-11Q213.23-12.4 211.75-14.25 210.28-16.1 210.28-19.05L210.28-19.05Q210.28-22.8 212.8-25.18 215.33-27.55 219.93-27.55L219.93-27.55ZM255.18-34.75L255.18-10.25Q255.18-7.1 253.85-4.58 252.53-2.05 249.83-0.58 247.13 0.9 243.18 0.9L243.18 0.9Q237.22 0.9 234.18-2.13 231.13-5.15 231.13-10.25L231.13-10.25 231.13-34.75 239.97-34.75 239.97-10.55Q239.97-8 240.7-6.8 241.43-5.6 243.18-5.6L243.18-5.6Q244.88-5.6 245.6-6.78 246.33-7.95 246.33-10.55L246.33-10.55 246.33-34.75 255.18-34.75ZM279.52-26.65L272.77 0Q271.47 5.25 267.97 8.08 264.47 10.9 258.92 11.2L258.92 11.2 258.02 5.45Q261.17 4.95 262.85 3.75 264.52 2.55 265.37 0L265.37 0 262.22 0 256.07-26.65 264.62-26.65 267.57-5.35 271.17-26.65 279.52-26.65Z" opacity="1" transform="matrix(1,0,0,1,0,0)" fill="#ffffff" class="undefined-text-0" data-fill-palette-color="primary" id="text-0"></path></svg></g></svg></g></svg></g></svg></g><g transform="matrix(1,0,0,1,113.77586408295187,0)"><svg viewBox="0 0 167.96827183409624 90.44532592005763" height="90.44532592005763" width="167.96827183409624"><g><svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" version="1.1" x="0" y="0" viewBox="5 25.768999099731445 90 48.462005615234375" enable-background="new 0 0 100 100" xml:space="preserve" height="90.44532592005763" width="167.96827183409624" class="icon-icon-0" data-fill-palette-color="accent" id="icon-0"><g fill="#01ffc6" data-fill-palette-color="accent"><rect x="5" y="43.077" fill="#01ffc6" width="3.462" height="13.846" data-fill-palette-color="accent"></rect><rect x="11.923" y="32.692" fill="#01ffc6" width="3.462" height="34.615" data-fill-palette-color="accent"></rect><rect x="18.846" y="25.769" fill="#01ffc6" width="6.924" height="48.462" data-fill-palette-color="accent"></rect><rect x="29.23" y="46.539" fill="#01ffc6" width="41.539" height="6.923" data-fill-palette-color="accent"></rect><rect x="91.538" y="43.077" fill="#01ffc6" width="3.462" height="13.846" data-fill-palette-color="accent"></rect><rect x="84.615" y="32.692" fill="#01ffc6" width="3.462" height="34.615" data-fill-palette-color="accent"></rect><rect x="74.23" y="25.769" fill="#01ffc6" width="6.924" height="48.462" data-fill-palette-color="accent"></rect></g></svg></g></svg></g><g></g></svg></g></svg></g></svg></g></svg></g></svg><rect width="395.52" height="247.2" fill="none" stroke="none" visibility="hidden"></rect></g><defs></defs>
		
	</div>
</body>
</html>


