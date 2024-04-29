document.querySelector('iframe').addEventListener('load', function() {
    document.getElementById('formContainer').style.display = 'none';
});
document.getElementById('showFormBtn').addEventListener('click', function() {
    document.getElementById('formContainer').style.display = 'block';
});