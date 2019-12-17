$.ajax({
    url: ROOT_PATH + "/getspecialities",
    type: "GET",
    dataType : "json",
    contentType:"application/json",
    success: function (data) {
        console.log(data);
        for (let specialtyIndex in data) {
            $("#specialties").append("<option value='" + specialtyIndex + "'>" + data[specialtyIndex].title + "</option>")
        }
        if (data && data.length > 0) {
            loadDoctors(0,data);
        }
        $("#specialties").change(function () {
            const selectedSpecialtyIndex = this.value;
            loadDoctors(selectedSpecialtyIndex,data);
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
                if (doctor.user.firstname) {
                    doctorName += doctor.user.firstname + " ";
                }
                if (doctor.user.lastname) {
                    doctorName += doctor.user.lastname;
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

    let speciality = $("#specialties").val() ? $("#specialties").val() : "";
    let doctorId = doctornameElem && $("#doctors").val() ? $("#doctors").val() : "";
    let date = dateElem && $("#date").val() ? $("#date").val() : "";
   // let time = timeElem && $("#time").val() ? $("#time").val() : "";
    let symptoms = descriptionElem && $("#description").val() ? $("#description").val() : "";
    let info = moreinfoElem && $("#more_comments").val() ? $("#more_comments").val() : "";

    //keep this element id  [..]
    $.ajax({
        url: ROOT_PATH+ "appointment/new",
        type: "POST",
        dataType: 'json',
        data: JSON.stringify({
            'specialityTitle': speciality,
            'doctorId': doctorId,
            'date': date,
//'time': time,
            'symptoms': symptoms,
            'info': info
        }),
        contentType: 'application/json',
        success: function (result) {
            alert("Data Saved: " + JSON.stringify(result));
        },
        error: function () {

        }
    })


}