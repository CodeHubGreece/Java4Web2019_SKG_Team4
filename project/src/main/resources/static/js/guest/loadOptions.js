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
            const specialityElement=document.querySelector("#specialties");
            const specialityId= specialityElement.value;
            $.ajax({
                url: ROOT_PATH + "/getspecialities/" + specialityId,
                type: "GET",
                dataType : "json",
                contentType:"application/json",
                success: function (data) {
                    console.log(data);
                    for (let doctorIndex in data) {
                        $("#doctors").append("<option value='" + doctorIndex + "'>" + data[doctorIndex].doctor_name + "</option>")
                    }
                },
            });
        })
    },
    error: function (xhr, resp, text) {
        alert("Error: " + text);
    }
});
function loadDoctors(selectedSpecialtyIndex,data) {

    if (selectedSpecialtyIndex >= 0 && data[selectedSpecialtyIndex] && data[selectedSpecialtyIndex].doctor) {
        const doctors = data[selectedSpecialtyIndex].doctor;
        $("#doctors").html('');
        for (let doctor of doctors) {
            let doctorName = "";
            if (doctor.user) {
                if (doctor.user.doctor_name) {
                    doctorName += doctor.user.doctor_name + " ";
                }
                if (doctor.user.doctor_surname) {
                    doctorName += doctor.user.doctor_surname+ " ";
                }
            }
            if (doctorName) {
                $("#doctors").append("<option value='" + doctor.doctorId + "'>" + doctorName + "</option>")
            }
        }
    }
}

// load specialities
function create_appointment(specialityElem, doctornameElem, dateElem, descriptionElem, moreinfoElem) {

    let specialityName = specialityElem && $("#specialties").val() ? $("#specialties").val() : "";
    let doctorId = doctornameElem && $("#doctors").val() ? $("#doctors").val() : "";
    let appointment_date = dateElem && $("#date").val() ? $("#date").val() : "";
    let appointment_description = descriptionElem && $("#description").val() ? $("#description").val() : "";
    let appointment_comments = moreinfoElem && $("#more_comments").val() ? $("#more_comments").val() : "";

    //keep this element id  [..]
    $.ajax({
        url: ROOT_PATH+ "/api/citizen/appointment",
        type: "POST",
        dataType: 'json',
        data: JSON.stringify({
            'specialityName': specialityName,
            'doctorId': doctorId,
            'appointment_date': appointment_date,
            'appointment_description': appointment_description,
            'appointment_comments': appointment_comments
        }),
        contentType: 'application/json',
        success: function (result) {
            alert("Data Saved: " + JSON.stringify(result));
        },
        error: function (e) {
alert(e)
        }
    })


}