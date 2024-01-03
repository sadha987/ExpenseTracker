
## 🚀 About Me
Aspiring Full Stack Java Developer | Proficient in Java, SQL, MySQL | Eager to Launch Software Development Career.

**Expense Tracker**

An expense tracker is a tool or application designed to help individuals or businesses monitor, manage, and analyze their financial expenditures. The primary purpose of an expense tracker is to provide a systematic way to record, categorize, and evaluate various types of expenses incurred over a specific period. Users can gain valuable insights into their spending patterns, identify areas for potential cost savings, and maintain better control over their financial health.

**Tools Used**

*java

*JavaFx

*CSS



## Other Common Github Profile Sections


🧠 I'm currently learning...

*Java FrameWorks

*Mango DB

*Js FrameWorks


## 🔗 Links

[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/sadhasivam-c)



## Usage/Examples

```javascript
document.addEventListener('DOMContentLoaded', () => {
  loadExpenses();
});

function addExpense() {
  const amountInput = document.getElementById('amount');
  const amount = parseFloat(amountInput.value);

  if (!isNaN(amount) && amount > 0) {
    fetch('/api/addExpense', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({ amount }),
    })
      .then(response => response.json())
      .then(data => {
        if (data.success) {
          loadExpenses();
          amountInput.value = '';
        } else {
          alert(data.message);
        }
      });
  } else {
    alert('Please enter a valid amount.');
  }
}

function loadExpenses() {
  fetch('/api/getExpenses')
    .then(response => response.json())
    .then(data => {
      const expenseList = document.getElementById('expenseList');
      expenseList.innerHTML = '<h2>Expense List</h2>';

      if (data.expenses.length === 0) {
        expenseList.innerHTML += '<p>No expenses yet.</p>';
      } else {
        expenseList.innerHTML += '<ul>';
        data.expenses.forEach((expense, index) => {
          expenseList.innerHTML += `<li>${index + 1}. $${expense.toFixed(2)}</li>`;
        });
        expenseList.innerHTML += '</ul>';
      }
    });
}
```


## Demo

Insert gif or link to demo

https://github.com/sadha987/ExpenseTracker.git
## 🛠 Skills
java,
javascript,
javaFX,
HTML,
CSS,
Flutter,
Dart.
