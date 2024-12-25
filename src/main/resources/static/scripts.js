const hamBurger = document.querySelector(".toggle-btn");

hamBurger.addEventListener("click", function () {
  document.querySelector("#sidebar").classList.toggle("expand");
});

if ('serviceWorker' in navigator) {
    window.addEventListener('load', () => {
      navigator.serviceWorker.register('/service-worker.js').then((registration) => {
        console.log('Service Worker registered with scope:', registration.scope);
      }).catch((error) => {
        console.log('Service Worker registration failed:', error);
      });
    });
  }
  