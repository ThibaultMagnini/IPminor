var div = document.getElementById('language');

var options = Array.from(div.querySelectorAll('button'));

options.forEach(element =>
    element.addEventListener('click',change,false)
);

function change(e){
    console.log("pls");
    window.location.replace('?lang=' + e.target.innerText);
}
