
jQuery().ready(function() {

  // Binding next button on first step
  $(".open1").unbind("click").click(function() {
        $(".frm").hide("fast");
        $("#sf2").show("slow");
   });

   // Binding next button on second step
   $(".open2").unbind("click").click(function() {
        $(".frm").hide("fast");
        $("#sf3").show("slow");
    });

     // Binding back button on second step
    $(".back2").unbind("click").click(function() {
      $(".frm").hide("fast");
      $("#sf1").show("slow");
    });

     // Binding back button on third step
     $(".back3").unbind("click").click(function() {
      $(".frm").hide("fast");
      $("#sf2").show("slow");
    });

    $(".open3").unbind("click").click(function() {
        // optional
        // used delay form submission for a seccond and show a loader image
        $("#loader").show();
        return false;
    });
});