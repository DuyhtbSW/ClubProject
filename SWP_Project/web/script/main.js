/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

const leftArrow = document.getElementById("leftArrow");
const rightArrow = document.getElementById("rightArrow");
const slider = document.getElementById("testimonial-slider");

let a = 0;
rightArrow.style.visibility = "hidden";
leftArrow.onclick = function () {
    a = a - 550;
    slider.style.left = a + "px";
    if(a == 0){
        rightArrow.style.visibility = "hidden";
    }else{
        rightArrow.style.visibility = "visible";
    }
    
    if(a == -1650){
        leftArrow.style.visibility = "hidden";
    }else{
        leftArrow.style.visibility = "visible";
    }
};

rightArrow.onclick = function () {
    a = a + 550;
    slider.style.left = a + "px";
    if(a == 0){
        rightArrow.style.visibility = "hidden";
    }else{
        rightArrow.style.visibility = "visible";
    }
    if(a == -1650){
        leftArrow.style.visibility = "hidden";
    }else{
        leftArrow.style.visibility = "visible";
    }
};