$(function () {
  const popoverTriggerList = document.querySelectorAll('[data-bs-toggle="popover"]')
  const popoverList = [...popoverTriggerList].map(popoverTriggerEl => new bootstrap.Popover(popoverTriggerEl))

  const appendToDo = function (data) {
    // var ToDoCode = '<a href="#" class="ToDo-link" data-id="' +
    //     data.id + '">' + data.name + '</a><br>';
    // $('#ToDo-list')
    // .append('<div>' + ToDoCode + '</div>');
    location.reload();
  };

  //Loading ToDos on load page
//    $.get('/ToDos/', function(response)
//    {
//        for(i in response) {
//            appendToDo(response[i]);
//        }
//    });

  //Show adding ToDo form
  $('#show-add-ToDo-form').click(function () {
    $('#ToDo-form').css('display', 'flex');
  });

  //Closing adding ToDo form
  $('#ToDo-form').click(function (event) {
    if (event.target === this) {
      $(this).css('display', 'none');
    }
  });

  //Getting ToDo
  $(document).on('click', '.ToDo-link', function () {
    var link = $(this);
    var ToDoId = link.data('id');
    $.ajax({
      method: "GET",
      url: '/toDos/' + ToDoId,
      success: function (response) {
        var code = '<span>Дата :' + response.date + '</span>';
        link.parent().append(code);
      },
      error: function (response) {
        if (response.status == 404) {
          alert('Дело не найдено!');
        }
      }
    });
    return false;
  });

  //Adding ToDo
  $('#save-ToDo').click(function () {
    var data = $('#ToDo-form form').serialize();
    $.ajax({
      method: "POST",
      url: '/toDos/',
      data: data,
      success: function (response) {
        $('#ToDo-form').css('display', 'none');
        var ToDo = {};
        ToDo.id = response;
        var dataArray = $('#ToDo-form form').serializeArray();
        for (i in dataArray) {
          ToDo[dataArray[i]['name']] = dataArray[i]['value'];
        }
        appendToDo(ToDo);
      }
    });
    return false;
  });

});