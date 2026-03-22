import { test, expect } from '@playwright/test' ;
import { LoginPage } from '../Pages/Loginpage';
import { BaseURL, USERNAME, PASSWORD }  from '../Utils/envconfig';

test("TC_001 Verify that user is able to login", async ({ page })=>{
    const loginpage = new LoginPage(page);
    await page.goto(BaseURL!);
    await loginpage.Login(USERNAME, PASSWORD);
    await expect(page.getByText('Swag Labs')).toBeVisible();


})

