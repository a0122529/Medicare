<div class="wrapper">
	<div class="col-lg-4 col-lg-offset-4">
		<div ng-show="error" class="alert alert-danger">{{error}}</div>
		<form class="form-signin" name="form" ng-submit="login()" role="form">
			<h2 class="form-signin-heading">Please login</h2>

			<label class="sr-only" for="username">Username</label> <input
				type="text" class="form-control" name="username" id="username"
				ng-model="username" placeholder="Email Address" required=""
				autofocus="" /> <span
				ng-show="form.username.$dirty && form.username.$error.required"
				class="help-block">Username is required</span> <label
				class="sr-only" for="password">Password</label> <input
				type="password" class="form-control" name="password"
				ng-model="password" placeholder="Password" required="" /> <span
				ng-show="form.password.$dirty && form.password.$error.required"
				class="help-block">Password is required</span>


			<!-- <label class="checkbox">
        <input type="checkbox" value="remember-me" id="rememberMe" name="rememberMe"> Remember me
      </label> -->
			<button class="btn btn-lg btn-primary btn-block"
				ng-disabled="form.$invalid || dataLoading" type="submit">Login</button>
			<img ng-if="dataLoading"
				src="data:image/gif;base64,R0lGODlhEAAQAPIAAP///wAAAMLCwkJCQgAAAGJiYoKCgpKSkiH/C05FVFNDQVBFMi4wAwEAAAAh/hpDcmVhdGVkIHdpdGggYWpheGxvYWQuaW5mbwAh+QQJCgAAACwAAAAAEAAQAAADMwi63P4wyklrE2MIOggZnAdOmGYJRbExwroUmcG2LmDEwnHQLVsYOd2mBzkYDAdKa+dIAAAh+QQJCgAAACwAAAAAEAAQAAADNAi63P5OjCEgG4QMu7DmikRxQlFUYDEZIGBMRVsaqHwctXXf7WEYB4Ag1xjihkMZsiUkKhIAIfkECQoAAAAsAAAAABAAEAAAAzYIujIjK8pByJDMlFYvBoVjHA70GU7xSUJhmKtwHPAKzLO9HMaoKwJZ7Rf8AYPDDzKpZBqfvwQAIfkECQoAAAAsAAAAABAAEAAAAzMIumIlK8oyhpHsnFZfhYumCYUhDAQxRIdhHBGqRoKw0R8DYlJd8z0fMDgsGo/IpHI5TAAAIfkECQoAAAAsAAAAABAAEAAAAzIIunInK0rnZBTwGPNMgQwmdsNgXGJUlIWEuR5oWUIpz8pAEAMe6TwfwyYsGo/IpFKSAAAh+QQJCgAAACwAAAAAEAAQAAADMwi6IMKQORfjdOe82p4wGccc4CEuQradylesojEMBgsUc2G7sDX3lQGBMLAJibufbSlKAAAh+QQJCgAAACwAAAAAEAAQAAADMgi63P7wCRHZnFVdmgHu2nFwlWCI3WGc3TSWhUFGxTAUkGCbtgENBMJAEJsxgMLWzpEAACH5BAkKAAAALAAAAAAQABAAAAMyCLrc/jDKSatlQtScKdceCAjDII7HcQ4EMTCpyrCuUBjCYRgHVtqlAiB1YhiCnlsRkAAAOwAAAAAAAAAAAA==" />

		</form>
	</div>
</div>