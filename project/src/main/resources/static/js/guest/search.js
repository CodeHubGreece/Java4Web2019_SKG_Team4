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
        error: function (e) {
            alert(e);
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
            alert("Coould not execute Edit");
        }
    
    });
}




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
                    $("#table-body").append("<tr id='appointmentRow" + appointment.appointment_id + "'><td>" + appointment.appointment_id + "</td><td>" + "1111" + "</td><td>" + "2222222" + "</td><td>" + appointment.appointment_date + "</td><td>" + appointment.appointment_description + "</td><td>" + appointment.appointment_comments + "</td><td> <button type='button' class='btn btn-danger' onclick='deleteAppointment("+appointment.appointment_id+")'> Delete </button> </td> <td> <button type='button' class='btn btn-success' onclick='editAppointment("+appointment.appointment_id+")'> Edit </button> </td></tr>");
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

function doctorsearch() {
    const fromDate = document.getElementById("fromAppointmentDate").value;
    const toDate = document.getElementById("toAppointmentDate").value;

    if (fromDate && toDate) {
        $.ajax({
            url:  "http://localhost:8080/getdoctorsearch",
            type: "POST",
            dataType: 'json',
            data: JSON.stringify({
                "fromDate": fromDate,
                "toDate": toDate,
            }),
            contentType: 'application/json',

            success: function (appointments) {
                console.log(appointments);
                $("#table-body").html("");
                jQuery.each(appointments, function (i, appointment) {
                    $("#table-body").append("<tr id='appointmentRow" + appointment.appointment_id + "'><td>" + appointment.appointment_id + "</td><td>" + "2222222" + "</td><td>" + appointment.appointment_date + "</td><td>" + appointment.appointment_description + "</td><td>" + appointment.appointment_comments + "</td><td> <button type='button' class='btn btn-danger'> Citizen Profile </button> </td> </tr>");
                });
            },
            error: function (e) {
                alert(e);
            }
        })
    } else {
        alert("Παρακαλω συμπληρωστε ολα τα πεδια");
    }
}
