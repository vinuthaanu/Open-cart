import { Page } from '@playwright/test';
import { loginpagelocators } from '../Locator/loginLocator';


export class LoginPage{

    constructor(public page: Page){}

    async Login(username: string, password: string)
    {
await this.page.fill(loginpagelocators.usernameinput,username);
await this.page.fill(loginpagelocators.passwordinput,password);
await this.page.click(loginpagelocators.loginbutton);

    }

}