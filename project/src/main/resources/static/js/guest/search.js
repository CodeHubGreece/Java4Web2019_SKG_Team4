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
    error: function () {
        alert("Done!");
    }

});

function deleteAppointment(id){
    $.ajax({
        url: ROOT_PATH + "/deleteAppointment/"+id,
        type: "DELETE",
        dataType : "json",
        contentType:"application/json",
        success: function (data) {
            console.log(data);
            $("#table-body #appointmentRow"+ id).remove();
        },
        error: function () {
            alert("Done!");
        }
    
    });
}
function editAppointment(ispecialityElem, doctornameElem, dateElem, descriptionElem, moreinfoElem){
   
    //let specialityName = specialityElem && specialityElem.value ? specialityElem.value : "";
    let doctorId = doctornameElem && doctornameElem.value ? doctornameElem.value : "";
    let appointment_date = dateElem && dateElem.value ?  dateElem.value : "";
    let appointment_description = descriptionElem &&descriptionElem.value ? descriptionElem.value : "";
    let appointment_comments = moreinfoElem && moreinfoElem.value ? moreinfoElem.value : "";


    $.ajax({
        url: ROOT_PATH + "/editAppointment/"+ id,
        type: "PUT",
        data: JSON.stringify({
                'specialityName':specialityName,
                'doctorId': doctorId,
                'appointment_date': appointment_date,
                'appointment_description': appointment_description,
                'appointment_comments': appointment_comments
            }),
        dataType : "json",
        contentType:"application/json",
        success: function (data) {
            console.log("edit" + data);
           
        },

        error: function () {
            alert("Done!");
        }
    
    });
}




function editAppointment(index){
    const appointment = globalAppointments[index];
    document.getElementById("date_time").value = appointment.appointment_date;
    document.getElementById("updateAppointment").onclick = function () {
        if (document.getElementById("date_time").value) {
            let selectedDate = new Date(document.getElementById("date_time").value).toISOString();
            $.ajax({
                url: ROOT_PATH + "/editAppointment",
                type: "PUT",
                dataType : "json",
                contentType:"application/json",
                data: JSON.stringify({
                    "appointment_id": appointment.appointment_id,
                    "appointment_date": selectedDate
                }),
                success: function (data) {
                    alert("Done!")
                    $("#table-body #appointmentRow"+ appointment.appointment_id).html("<td>" + appointment.appointment_id + "</td><td>" + appointment.appointment_date + "</td><td>" + appointment.appointment_description + "</td><td>" + appointment.appointment_comments + "</td><td> <button type='button' class='btn btn-danger' onclick='deleteAppointment("+appointment.appointment_id+")'> Delete </button> </td> <td> <button type='button' class='btn btn-success' onclick='editAppointment("+i+")'> Edit </button> </td>")
                },
                error: function () {
                    alert("Done!");
                }
            
            });
        } else {
            alert("Wrong date");
        }
    }
    $("#editAppointment").modal();
   
}



var globalAppointments = [];
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
                globalAppointments = appointments;
                    console.log(appointments);
                $("#table-body").html("");
                jQuery.each(appointments, function (i, appointment) {
                    $("#table-body").append("<tr id='appointmentRow" + appointment.appointment_id + "'><td>" + appointment.appointment_id + "</td><td>" + appointment.appointment_date + "</td><td>" + appointment.appointment_description + "</td><td>" + appointment.appointment_comments + "</td><td> <button type='button' class='btn btn-danger' onclick='deleteAppointment("+appointment.appointment_id+")'> Delete </button> </td> <td> <button type='button' class='btn btn-success' onclick='editAppointment("+i+")'> Edit </button> </td></tr>");
                });
                //$("#appointmens").append("</tbody>");
                //  $("#body tr").click(function() {
                //     loadAppointment($(this).children("td").html());
                //  });
                // $('#appointmens').DataTable();

            },
            error: function () {
                alert("Done!");
            }
        })
    } else {
        alert("Παρακαλω συμπληρωστε ολα τα πεδια");
    }
}