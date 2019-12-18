$.ajax({
    url: ROOT_PATH + "/searchappointment",
    type: "GET",
    dataType : "json",
    contentType:"application/json",


    success: function search(appointment) {

    $("#appointments").append("<tbody>");
    jQuery.each(appointments, function(i,appointment) {
        $("#appointments").append("<tr id='appointmentRow" + appointment.appointment_id + "'><td>" + appointment.appointment_id + "</td><td>" + appointment.specialityName + "</td></tr>" + appointment.doctorId + "</td></tr>" + appointment.appointment_date + "</td></tr>" + appointment.appointment_description + "</td></tr>"+ appointment.appointment_comments + "</td></tr>");
     });
     $("#appointmens").append("</tbody>");
     $("#appointmens tr").click(function() {
        loadAppointment($(this).children("td").html());
     });
    $('#appointmens').DataTable();



},
});