const ROOT_PATH = "http://localhost:8080";

$.ajax({
    url: ROOT_PATH + "/getspecialities",
    type: "GET",
    dataType : "json",
    contentType:"application/json",
    success: function (data) {
        console.log(data);
        for (let specialtyIndex in data) {
            $("#specialties").append("<option value='" + data[specialtyIndex].specialty_id + "'>" + data[specialtyIndex].specialty_name + "</option>")
        }
        $("#specialties").change(function () {
            const specialityElement = document.querySelector("#specialties");
            const specialityId = specialityElement.value;
        })
    },
    error: function (e) {
        alert(e);
    }

});

function search() {
    const fromDate = document.getElementById("fromAppointmentDate").value;
    const toDate = document.getElementById("toAppointmentDate").value;
    const specialtyId = document.getElementById("specialties").value;

    if (fromDate && toDate && specialtyId) {
        $.ajax({
            url:  "http://localhost:8080/getcitizensearch",
            type: "POST",
            dataType: 'json',
            data: JSON.stringify({
                "fromDate": fromDate,
                "toDate": toDate,
                "specialtyId":specialtyId
            }),
            contentType: 'application/json',

            success: function (appointments) {
                    console.log(appointments);
                $("#table-body").html("");
                jQuery.each(appointments, function (i, appointment) {
                    $("#table-body").append("<tr id='appointmentRow" + appointment.appointment_id + "'><td>" + appointment.appointment_id + "</td><td>" + "1111" + "</td><td>" + "2222222" + "</td><td>" + appointment.appointment_date + "</td><td>" + appointment.appointment_description + "</td><td>" + appointment.appointment_comments + "</td></tr>");
                });
                //$("#appointmens").append("</tbody>");
                //  $("#body tr").click(function() {
                //     loadAppointment($(this).children("td").html());
                //  });
                // $('#appointmens').DataTable();

            },
            error: function (e) {
                alert(e);
            }
        })
    } else {
        alert("Παρακαλω συμπληρωστε ολα τα πεδια");
    }
}