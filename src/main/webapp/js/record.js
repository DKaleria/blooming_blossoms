function clearAnswers() {
    document.getElementById("questions").reset();
}

function processData() {

    // Получение данных из формы
    const form = document.getElementById("questions");
    const formData = new FormData(form);

    // Обработка данных и вывод результатов в модальное окно
    let result = "Ваша запись обработана:\n";
    for (const entry of formData.entries()) {
        result += `${entry[0]}: ${entry[1]}\n`;
    }

    // Отображение результатов в модальном окне
    const modal = document.getElementById("modal");
    modal.classList.add('show');
    const modalContent = document.getElementById("result");
    modalContent.textContent = result;
    modal.style.display = "block";

    // Закрытие модального окна при нажатии на кнопку "закрыть"
    const closeBtn = document.getElementsByClassName("close")[0];
    closeBtn.onclick = function () {
        modal.style.display = "none";
    }
}
