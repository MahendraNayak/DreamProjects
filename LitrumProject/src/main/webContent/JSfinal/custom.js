function getSMCBasedOnMC(ID,PAGE){

     alert(PAGE+" Here "+ID);
    /*var categoriesForm  = {
    	"mainCategoryId":ID,
    	"mainCategoryName":'MC1'
    }*/

    $.ajax({
        url: '/LitrumWebServer/subMainCategory/list',
        type: 'GET',
        dataType: 'json',
        data: "mainCategoryId="+ID,
        success: function (data) {
            alert("success"+data);
        },
        error: function (e) {
            alert('error'+e);
        }
    });
}


