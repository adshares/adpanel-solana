import {Component, EventEmitter, Output} from '@angular/core';
import {MatDialogRef} from '@angular/material';
import {RefLink} from "models/settings.model";

@Component({
  selector: 'app-ref-link-editor-dialog',
  templateUrl: './ref-link-editor-dialog.component.html',
  styleUrls: ['./ref-link-editor-dialog.component.scss'],
})
export class RefLinkEditorDialogComponent {
  @Output() public refLinkSaved = new EventEmitter<RefLink>();

  constructor(
    public dialogRef: MatDialogRef<RefLinkEditorDialogComponent>
  ) {
  }

  onRefLinkSaved(refLink: RefLink): void {
    this.dialogRef.close()
    this.refLinkSaved.emit(refLink);
  }
}
