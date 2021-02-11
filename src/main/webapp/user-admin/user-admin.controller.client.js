// fields
var $firstNameFld
var $lastNameFld
var $usernameFld
var $emailFld
var $passwordFld
var $DOBFld
var $roleFld
// btns
var $createUserBtn
var $filterUserBtn
var $updateUserBtn

var theTableBody
var userService = new UserServiceClient()
var users = [];
var filteredUsers = [];
var selectedUser = null

// create a new user
function createUser(user) {
    userService.createUser(user)
        .then(function (actualUser) {
            users.push(actualUser)
            renderUsers(users)
        })
}

// select the specific user
function selectUser(event) {
    var selectBtn = jQuery(event.target)
    var theId = selectBtn.attr("id")
    selectedUser = users.find(user => user._id === theId)
    $firstNameFld.val(selectedUser.firstname)
    $lastNameFld.val(selectedUser.lastname)
    $usernameFld.val(selectedUser.username)
    $emailFld.val(selectedUser.email)
    $passwordFld.val(selectedUser.password)
    $DOBFld.val(selectedUser.DOB)
    $roleFld.val(selectedUser.role)
}

// delete the specific user
function deleteUser(event) {
    console.log(event.target)
    var deleteBtn = jQuery(event.target)
    var theClass = deleteBtn.attr("class")
    var theIndex = deleteBtn.attr("id")
    var theId = users[theIndex]._id
    console.log(theClass)
    console.log(theIndex)
    // delete the user data from the server
    userService.deleteUser(theId)
        .then(function (status) {
            users.splice(theIndex, 1)
            renderUsers(users)
        })
}

// update an existing user with the input values
function updateUser() {
    console.log(selectedUser)
    selectedUser.firstname = $firstNameFld.val()
    selectedUser.lastname = $lastNameFld.val()
    selectedUser.username = $usernameFld.val()
    selectedUser.email = $emailFld.val()
    selectedUser.password = $passwordFld.val()
    selectedUser.DOB = $DOBFld.val()
    selectedUser.role = $roleFld.val()
    // update the user data for the server
    userService.updateUser(selectedUser._id, selectedUser)
        .then(function (status) {
            var index = users.findIndex(user => user._id === selectedUser._id)
            users[index] = selectedUser
            renderUsers(users)
        })
    // clear input fields
    $firstNameFld.val(""),
        $lastNameFld.val(""),
        $usernameFld.val(""),
        $emailFld.val(""),
        $passwordFld.val(""),
        $DOBFld.val(""),
        $roleFld.val("")
}

// render the filtered user data only
function filterUser(filter) {
    if (!jQuery.isEmptyObject(filter.firstname)) {
        filteredUsers = users.filter(user => user.firstname === filter.firstname)
    } else {
        filteredUsers = users
    }
    if (!jQuery.isEmptyObject(filter.lastname)) {
        filteredUsers = filteredUsers.filter(user => user.lastname === filter.lastname)
    }
    if (!jQuery.isEmptyObject(filter.username)) {
        filteredUsers = filteredUsers.filter(user => user.username === filter.username)
    }
    if (!jQuery.isEmptyObject(filter.email)) {
        filteredUsers = filteredUsers.filter(user => user.email === filter.email)
    }
    if (!jQuery.isEmptyObject(filter.DOB)) {
        filteredUsers = filteredUsers.filter(user => user.DOB === filter.DOB)
    }
    if (!jQuery.isEmptyObject(filter.role)) {
        filteredUsers = filteredUsers.filter(user => user.role === filter.role)
    }
    console.log(filteredUsers)
    renderUsers(filteredUsers)
}

// render all users on the admin board
function renderUsers(users) {
    console.log(users)
    theTableBody.empty()
    for (var i = 0; i < users.length; i++) {
        var user = users[i]
        theTableBody
            .append(`
                <tr>
                    <td>${user.firstname}</td>
                    <td>${user.lastname}</td>
                    <td>${user.username}</td>
                    <td>${user.email}</td>
<!--                    <td>${user.password}</td>-->
                    <td><i class="fa fa-eye-slash"></i></td>
                    <td>${user.DOB}</td>
                    <td>${user.role}</td>
                    <td></td>
                    <td>
                        <button class="delete-user-btn fa fa-times fa-2x"
                                id="${i}"></button>
                    </td>
                    <td>
                        <button class="select-user-btn fa fa-pencil fa-2x"
                                id="${user._id}"></button>
                    </td>
                </tr>
            `)
    }
    jQuery(".delete-user-btn")
        .click(deleteUser)
    jQuery(".select-user-btn")
        .click(selectUser)
}

// initialize the admin board with all existing user data from server
function init() {
    $firstNameFld = $(".firstname-fld")
    $lastNameFld = $(".lastname-fld")
    $usernameFld = $(".username-fld")
    $emailFld = $(".email-fld")
    $passwordFld = $(".password-fld")
    $DOBFld = $(".DOB-fld")
    $roleFld = $(".role-fld")

    theTableBody = jQuery("tbody")

    $filterUserBtn = $(".filter-user-btn")
    $filterUserBtn.click(() => {
        filterUser({
            firstname: $firstNameFld.val(),
            lastname: $lastNameFld.val(),
            username: $usernameFld.val(),
            email: $emailFld.val(),
            DOB: $DOBFld.val(),
            role: $roleFld.val()
        })
    })

    $updateUserBtn = $(".update-user-btn")
    $updateUserBtn.click(updateUser)

    // create a new user with the input values
    $createUserBtn = $(".create-user-btn")
    $createUserBtn.click(() => {
            createUser({
                firstname: $firstNameFld.val(),
                lastname: $lastNameFld.val(),
                username: $usernameFld.val(),
                email: $emailFld.val(),
                password: $passwordFld.val(),
                DOB: $DOBFld.val(),
                role: $roleFld.val()
            })
            // clear input fields
            $firstNameFld.val(""),
                $lastNameFld.val(""),
                $usernameFld.val(""),
                $emailFld.val(""),
                $passwordFld.val(""),
                $DOBFld.val(""),
                $roleFld.val("")
        }
    )

    // retrieve all users from the server
    userService.findAllUsers()
        .then(function (actualUsersFromServer) {
            users = actualUsersFromServer
            renderUsers(users)
        })
}

jQuery(init)