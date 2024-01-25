$(document).ready(function() {

        const exampleModal = document.getElementById('exampleModal')
        exampleModal.addEventListener('show.bs.modal', event => {

          const button = event.relatedTarget
          const recipient = button.getAttribute('data-bs-whatever')

          const modalTitle = exampleModal.querySelector('.modal-title')
          modalTitle.textContent = '글 등록'


         $(document).ready(function() {

             // 등록 버튼 클릭 이벤트 핸들러
             $('.btn.btn-primary').off('click').on('click', function() {
                 var data = {
                     title: $('#title-name').val(),
                     author: $('#author-name').val(),
                     content: $('#message-text').val()
                 };
                 $.ajax({
                     type: 'POST',
                     url: '/posts',
                     dataType: 'json',
                     contentType: 'application/json; charset=utf-8',
                     data: JSON.stringify(data)
                 }).done(function() {
                     location.reload();
                 }).fail(function(error) {
                     console.log(error);
                     alert('오류입니다.');
                 });
             });

             // 취소 버튼 클릭 이벤트 핸들러
             $('.btn.btn-secondary').off('click').on('click', function() {
                 $('#title-name').val('');
                 $('#author-name').val('');
                 $('#message-text').val('');
             });

         });


        })
    });

