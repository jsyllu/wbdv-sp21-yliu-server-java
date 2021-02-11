function UserServiceClient() {
    this.createUser = createUser;
    this.findAllUsers = findAllUsers;
    // this.findUserById = findUserById;
    this.deleteUser = deleteUser;
    this.updateUser = updateUser;
    this.url = 'https://wbdv-generic-server.herokuapp.com/api/001401345/users';
    var self = this;

    // POST - create an user and add to server, return new user stored in the server
    function createUser(user) {
        return fetch(self.url, {
            method: 'POST',
            headers: {
                'content-type': 'application/json'
            },
            body: JSON.stringify(user)
        }).then(function (response) {
            return response.json()
        })
    }

    // GET - find all users, return array of users stored in the server DB
    function findAllUsers() {
        return fetch(self.url)
            .then(function (response) {
                return response.json()
            })
    }

    // GET - find user by id
    // function findUserById(userId) {
    //     return fetch(self.url)
    //         .then(function (response) {
    //             return response.json()
    //         })
    // }

    // PUT - update an existing user by user id, return status of successful update of user
    function updateUser(userId, user) {
        return fetch(`${self.url}/${userId}`, {
            method: 'PUT',
            headers: {
                'content-type': 'application/json'
            },
            body: JSON.stringify(user)
        }).then(response => response.json())
    }

    // DELETE - delete an existing user by user id from the server
    function deleteUser(userId) {
        return fetch(`${self.url}/${userId}`, {
            method: 'DELETE'
        })
    }
}