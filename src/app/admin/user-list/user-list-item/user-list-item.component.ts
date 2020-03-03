import { Component, Input } from '@angular/core';
import { UserInfo } from 'models/settings.model';
import { AdminService } from "admin/admin.service";
import { Store } from "@ngrx/store";
import { AppState } from "models/app-state.model";
import { Router } from "@angular/router";
import { ImpersonationService } from "../../../impersonation/impersonation.service";
import { SessionService } from "../../../session.service";

@Component({
  selector: 'app-user-list-item',
  templateUrl: './user-list-item.component.html',
  styleUrls: ['./user-list-item.component.scss'],
})
export class UserListItemComponent {
  @Input() user: UserInfo;

  constructor(
    private adminService: AdminService,
    private store: Store<AppState>,
    private impersonationService: ImpersonationService,
    private sessionService: SessionService,
    private router: Router,
  ) {
  }

  handleImpersonating() {
    this.adminService.impersonateUser(this.user.id).subscribe(
      (token) => {
        this.impersonationService.setImpersonationToken(token);
        if (this.user.isPublisher) {
          this.router.navigate([`/${'publisher'}`, 'dashboard']);
          this.sessionService.setAccountTypeChoice('publisher');
        } else {
          this.router.navigate([`/${'advertiser'}`, 'dashboard']);
          this.sessionService.setAccountTypeChoice('advertiser');
        }
      }
    )
  }

  get userRole(): string {
    if (this.user.isAdmin) {
      return 'Admin'
    } else if (this.user.isAdvertiser && this.user.isPublisher) {
      return 'Adv / Pub'
    } else {
      return this.user.isAdvertiser ? 'Advertiser' : 'Publisher'
    }
  }
}
