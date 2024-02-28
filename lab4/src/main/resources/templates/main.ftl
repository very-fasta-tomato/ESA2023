<div class="container" align="center" valign="middle">
    <img src="beautiful.jpg" >
    <div class="user-input">
        Fill the table user
        <form action="./user/create" method="post">
            <input type="text" name="username", placeholder="Username">
            <button type="submit">Save</button>
        </form>
    </div>
    <div class="users">
        <div class="table-user" >
            <table border="1" cellspacing="0" cellpadding="1">
                <thead>
                    <tr>
                        <th>id_user</th>
                        <th>username</th>
                    </tr>
                </thead>
                <tbody>
                    <#list users as user>
                        <tr>
                            <td>${user.id}</td>
                            <td>${user.username}</td>
                        </tr>
                    </#list>
                </tbody>
            </table>
        </div>
    </div>
    <div class="container-delete">
        <div class="user-input">
            select user id to delete
            <form action="./user/delete" method="post">
                <input type="text" name="id", placeholder="Id">
                <button type="submit">Delete</button>
            </form>
        </div>
    </div>

    <div class="container-input">
        <div class="posts-input">
            Fill the table Post
            <form action="./post/create" method="post">
                <input type="text" name="title", placeholder="Title">
                <input type="text" name="content", placeholder="Content">
                <input type="text" name="user_id", placeholder="User_Id">
                <button type="submit">Save</button>
            </form>
        </div>
    </div>

    <div class="posts">
        <div class="table-post">
            <table border="1" cellspacing="0" cellpadding="1">
                <thead>
                    <tr>
                        <th>id</th>
                        <th>title</th>
                        <th>content</th>
                        <th>user_id</th>
                    </tr>
                </thead>
                <tbody>
                    <#list posts as post>
                        <tr class="tableBody">
                            <td>${post.id} </td>
                            <td>${post.title} </td>
                            <td>${post.content} </td>
                            <td>${post.user_id} </td>
                        </tr>
                    </#list>
                </tbody>
            </table>
        </div>
    </div>
    <div class="container-delete">
        <div class="user-input">
            select post id to delete
            <form action="./post/delete" method="post">
                <input type="text" name="id", placeholder="Id">
                <button type="submit">Delete</button>
            </form>
        </div>
    </div>
</div>