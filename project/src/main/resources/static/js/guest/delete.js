$.ajax({ url: `/api/photo/${$(this).attr('photoId')}`, method: "DELETE" })

.then(function (data) {
    some code...
})
.catch(function (err) {
    some code...
})